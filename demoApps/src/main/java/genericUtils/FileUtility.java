package genericUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {

	public String fetchDataFromPropertyFile(String Key) throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\Computer Mall\\eclipse-workspace123\\demoApps\\src\\test\\resources\\TestData\\demoApps.properties");
		
		Properties prop = new Properties();
		
		prop.load(fis);
		
		return prop.getProperty(Key); // ask -- return kyun kiya??
		
	}
	
	public String fetchDataFromExcelSheet(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\Computer Mall\\eclipse-workspace123\\demoApps\\src\\test\\resources\\TestData\\DemoAppsTestCases.xlsx");
	
		return WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue(); 
		
	}
}

