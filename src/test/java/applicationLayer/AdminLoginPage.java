package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage {
	@FindBy(xpath ="//button[@name='btnreset']")
	WebElement ObjReset;
	@FindBy(xpath = "//input[@placeholder='User Name']")
	WebElement Objeuser;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement Objpass;
	@FindBy(xpath ="//button[@name='btnsubmit']")
	WebElement ObjLogin;
	public void adminLogin(String user,String pass)
	{
		ObjReset.click();
		Objeuser.sendKeys(user);
		Objpass.sendKeys(pass);
		ObjLogin.click();
	}

}
