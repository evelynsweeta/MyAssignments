package commonintegration;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelIntegration {

	public static String[][] ExcelData(String excelsheet) throws IOException {
	        //open the WB
			XSSFWorkbook wbook=new XSSFWorkbook("./data/"+excelsheet+".xlsx");
			//Identify the Worksheet
		    XSSFSheet wSheet = wbook.getSheet("datasheet1");
		   //get the total row count without header
		    int rowCount=wSheet.getLastRowNum();
		    System.out.println(rowCount);
		    //get the total column count
		    int columnCount = wSheet.getRow(1).getLastCellNum();
		    System.out.println(columnCount);
		    String [][] data=new String[rowCount][columnCount];
		    //entireData
		    for (int i = 1; i <= rowCount; i++) {
				for (int j = 0; j < columnCount; j++) {
					String values = wSheet.getRow(i).getCell(j).getStringCellValue();
					//assigning values
					data[i-1][j]=values;					
				}
			}
		    //close the workbook
		    wbook.close();
		    return data;
	}
	
}