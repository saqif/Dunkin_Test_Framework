package com.dunkin.shadman.onlineStore.helper.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.dunkin.shadman.onlineStore.helper.logger.LoggerHelper;
import com.dunkin.shadman.onlineStore.helper.resource.ResourceHelper;

/**
 * 
 * @author shadmanshahriyar
 *
 */

public class ExcelHelper {
	Logger log = LoggerHelper.getLogger(ExcelHelper.class);
	
	/**
	 * This method will help us to get the data from excel sheet
	 * @return Object[][]
	 */
	
	public Object[][] getExcelData(String excelLocation, String sheetName) {
		try {
			Object dataSet[][] = null;
			log.info("Trying to read excel sheet");
			log.info(excelLocation);
			
			FileInputStream file = new FileInputStream(new File(excelLocation));
			log.info("successfully converted xlxs to fileinputstream");
			XSSFWorkbook workbook = new XSSFWorkbook(file); //create workbook instance
			log.info("got the workbook");
			XSSFSheet sheet = workbook.getSheet(sheetName); //get sheet by sheet name
			log.info("got the sheet : " + sheetName);
			int totalRow = sheet.getLastRowNum(); //getting total active number of row
			log.info("total number of row : " + totalRow);
			int totalCollumn = sheet.getRow(0).getLastCellNum();// getting total active number of cells
			log.info("total number of collumn : " + totalCollumn);
			dataSet = new Object[totalRow][totalCollumn];
			
			Iterator<Row> rowIterator = sheet.iterator(); //iterate through each rows one by one
			int i = 0;
			while(rowIterator.hasNext()) {
				Row row = rowIterator.next();
				
				Iterator<Cell> cellIterator = row.cellIterator();
				int j = 0;
				while(cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					
					if(i>0) {
						
						int ci = i-1;
						if(getValue(cell).equals("defaultCase")) {
							log.info("Error: cell number ["+ci+"]["+j+"]-> CellType not matched!");
						} else {
							dataSet[ci][j] = getValue(cell);
							log.info("Added: cell number ["+ci+"]["+j+"]->" + dataSet[ci][j]);
						}
	
					} else {
						log.info("Important : Ignoring first row. Because it contains only headers");
					}
					
					j++;
				}	
				i++;
			}
			
			return dataSet;
		} catch(Exception e) {
			log.info("Error reading excel file...");
			log.info("Details: "+e.getCause());
			e.printStackTrace();
			return null;
		}
	}
	
	public Object getValue(Cell cell) {
		switch(cell.getCellTypeEnum()) {
			case STRING:
				return cell.getStringCellValue(); 
			case NUMERIC:
				return cell.getNumericCellValue();
			case BOOLEAN:
				return cell.getBooleanCellValue();
			case FORMULA:
				return cell.getCellFormula();
			default:
				return "defaultCase";
		}
	}
	
	/**
	 * This repeatString method will repeat any string for given time
	 * @param string
	 * @param repetitions
	 * @return String
	 */
	
	private String repeatString(final String string, final int repetitions) {
	    return new String(new char[repetitions]).replace("\0", string);
	}
	
	/**
	 * This getLongestSize method will give the highest String length 
	 * from a double dimension Object array
	 * @param obj
	 * @return 
	 */
	
	private int getLongestSize(Object[][] obj) {
		int max = obj[0][0].toString().length();
		for(int i = 0; i<obj.length; i++) {
			for(int j = 0; j<obj[i].length; j++) {
				if(max<obj[i][j].toString().length()) {
					max = obj[i][j].toString().length();
				}
			}
		}
		return max;
	}
	
	public void printExcelSheet(String sheetLocation, String sheetName) {
		ExcelHelper ex = new ExcelHelper();
		String excelLocation = ResourceHelper.getResourcePath(sheetLocation);
		
		Object[][] obj = ex.getExcelData(excelLocation, sheetName);
		
		//getting the highest String length
		int maxL = getLongestSize(obj);
		
		//printing first divider
		System.out.println(repeatString("=",((maxL+2)*obj[0].length)-1));
		
		for(int i = 0; i<obj.length; i++) {
			for(int j = 0; j<obj[i].length; j++) {
				//dividing the spaces
				int lengthDiff = maxL - obj[i][j].toString().length();
				
				//printing the value with spaces on both side
				System.out.print("|" + repeatString(" ", (lengthDiff / 2)) + obj[i][j] + repeatString(" ", (lengthDiff / 2)));
			}
			
			//ending the column
			System.out.println("|");
			
			//ending the row
			System.out.println(repeatString("=",((maxL+2)*obj[0].length)-1));
		}
	}
	
	public  void updateResult(String sheetLocation, String sheetName, String testCaseName, String testStatus) {
		try {
			log.info("Trying to read excel sheet");
			FileInputStream file = new FileInputStream(new File(sheetLocation));
			XSSFWorkbook workbook = new XSSFWorkbook(file); //create workbook instance
			XSSFSheet sheet = workbook.getSheet(sheetName); //get sheet by sheet name
			log.info("Success!");
			int totalRow = sheet.getLastRowNum() + 1; //getting total active number of row
			
			for(int i = 1; i<totalRow; i++) {
				XSSFRow r = sheet.getRow(i);
				String ce = r.getCell(0).getStringCellValue(); //here 0 is the cell number
				if(ce.contains(testCaseName)) {
					r.createCell(1).setCellValue(testStatus); // here 1 is the second cell number
					file.close();
					FileOutputStream fileOut = new FileOutputStream(new File(sheetLocation));
					workbook.write(fileOut);
					log.info("Updated -> " + testCaseName + ":" + testStatus);
					fileOut.close();
					break;
				}
			}
		} catch(Exception e) {
			log.info("Error reading excel file...");
			log.info("Details: "+e.getCause());
		}
	}
	
	
	
	public static void main(String[] args) {
		String sheetLocation = "/src/main/resources/excelfiles/workbook.xlsx";
		new ExcelHelper().printExcelSheet(sheetLocation, "login");
		//System.out.println(new String(new char[5]).replace("\0", "*"));
	}
}
