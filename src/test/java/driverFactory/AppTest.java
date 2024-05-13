package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Utilities.ExcelFileUtil;
import applicationLayer.CustomerPage;
import config.AppUtil;

public class AppTest extends AppUtil{

	String inputpath = "./Fileinput/Customer.xlsx";
	String Outputpath="./Fileoutput/DataDrivenResults.Xlsx";
	String sheet="CustomerData";
	@Test
	public void Startest() throws Throwable

	{
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		int rc = xl .rowcount("CustomerData");
		Reporter.log("No of rows are::"+rc,true);
		for(int i=1;i<=rc;i++)
		{
			String cname = xl.getcelldata(sheet, i, 0);
			String Address = xl.getcelldata(sheet, i, 1);
			String City=xl.getcelldata(sheet, i, 2);
			String Country=xl.getcelldata(sheet, i, 3);
			String cperson=xl.getcelldata(sheet, i, 4);
			String pnumber=xl.getcelldata(sheet, i, 5);
			String Email=xl.getcelldata(sheet, i, 6);
			String Mnumber=xl.getcelldata(sheet, i, 7);
			String Notes=xl.getcelldata(sheet, i, 8);
			CustomerPage cus =PageFactory.initElements(driver, CustomerPage.class);
			boolean res = cus.Customer_Validate(cname, Address, City, Country, cperson, pnumber, Email, Mnumber, Notes);
			if(res) {
				xl.setCellData(sheet, i, 9, "pass", Outputpath);
			}
			else
			{
				xl.setCellData(sheet, i, 9, "fail", Outputpath);
			}
		}
	}
}