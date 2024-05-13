package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerPage {
	@FindBy(xpath ="(//a[text()='Customers'])[2]")
	WebElement ObjClickCustomerLink;
	@FindBy(xpath = "//span[@data-caption='Add']")
	WebElement ObjAddicon;
	@FindBy(xpath = "//input[@name='x_Customer_Number']")
	WebElement ObjCustomerNumber;
	@FindBy(xpath = "//input[@placeholder='Customer Name']")
	WebElement ObjCustomerName;
	@FindBy(xpath = "//textarea[@placeholder='Address']")
	WebElement ObjAddress;
	@FindBy(xpath = "//input[@placeholder='City']")
	WebElement ObjCity;
	@FindBy(xpath = "//input[@placeholder='Country']")
	WebElement ObjCountry;
	@FindBy(xpath = "//input[@placeholder='Contact Person']")
	WebElement ObjContactPerson;
	@FindBy(xpath = "//input[@placeholder='Phone Number']")
	WebElement ObjPhoneNumber;
	@FindBy(xpath = "//input[@placeholder='Email']")
	WebElement ObjEmail;
	@FindBy(xpath = "//input[@placeholder='Mobile Number']")
	WebElement ObjMobileNumber;
	@FindBy(xpath = "//input[@placeholder='Notes']")
	WebElement ObjNotes;
	@FindBy(id = "btnAction")
	WebElement ObjClickAsBtn;
	@FindBy(xpath = "//button[normalize-space()='OK!']")
	WebElement ObjClickConfirm;
	@FindBy(xpath = "//button[starts-with(text(),'OK')]")
	WebElement ObjAlerOk;
	@FindBy(xpath = "//span[@data-caption='Search']")
	WebElement ObjSearchPanel;
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement ObjSearchTextbox;
	@FindBy(xpath = "//button[@name='btnsubmit']")
	WebElement ObjSearchButton;
	@FindBy(xpath = "//table[@class='table ewTable']/tbody/tr[1]/td[5]/div/span/sapan")
	WebElement webTable;
	public boolean Customer_Validate(String CustomerName,String Address,String City,
			String Country,String ContactPerson,String PhoneNumber,String Email,String MobileNumber,String Notes) throws Throwable
	{
		ObjClickCustomerLink.click();
		ObjAddicon.click();
		String Exp_Data=ObjCustomerNumber.getAttribute("value");
		ObjCustomerName.sendKeys(CustomerName);
		ObjAddress.sendKeys(Address);
		ObjCity.sendKeys(City);
		ObjCountry.sendKeys(Country);
		ObjContactPerson.sendKeys(ContactPerson);
		ObjPhoneNumber.sendKeys(PhoneNumber);
		ObjEmail.sendKeys(Email);
		ObjMobileNumber.sendKeys(MobileNumber);
		ObjNotes.sendKeys(Notes);
		ObjClickAsBtn.click();
		ObjClickConfirm.click();
		Thread.sleep(3000);
		ObjAlerOk.click();
		Thread.sleep(3000);
		if(!ObjSearchTextbox.isDisplayed())
			ObjSearchPanel.click();
		ObjSearchTextbox.clear();
		ObjSearchTextbox.sendKeys(Exp_Data);
		ObjSearchButton.click();
		Thread.sleep(3000);
		String Act_Data =webTable.getText();
		if(Act_Data.equals(Exp_Data))
		{
			Reporter.log("Customer number is matching "+Exp_Data+"      "+Act_Data);
			return true;
		}
		else
		{
			Reporter.log("Customer number is not matching"+Exp_Data+"   "+Act_Data);
			return false;
		}
	}
}
