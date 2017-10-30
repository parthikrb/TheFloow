package thefloow.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import thefloow.utils.Log;

public class LoginPage {
String buttonId = "com.thefloow.flo:id/btn_login";
	@SuppressWarnings("unused")
	private AppiumDriver<AndroidElement> driver;

	@AndroidFindBy(id = "com.thefloow.flo:id/edit_text_email")
	static MobileElement eMailTxtFld;

	@AndroidFindBy(id = "com.thefloow.flo:id/edit_text_password")
	static MobileElement passwordTxtFld;

	@AndroidFindBy(id = "com.thefloow.flo:id/btn_login")
	static MobileElement logInBtn;

	@AndroidFindBy(id = "com.thefloow.flo:id/text_view_forgot_password")
	static MobileElement forgotPasswordLnk;

	@AndroidFindBy(id = "com.thefloow.flo:id/text_view_create_account")
	static MobileElement createAccntLnk;

	public LoginPage(AppiumDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void logInToApp(String emailId, String password) {
		Log.info("Passing value to eMail Id: " + emailId);
		eMailTxtFld.sendKeys(emailId);
		Log.info("Passing value to Password: " + password);
		passwordTxtFld.sendKeys(password);
		Log.info("Clicking Login button");
		logInBtn.click();
	}
	
	public boolean isLogInBtnPresent(AndroidDriver<AndroidElement> driver) {  
	    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
	    try {  
	        driver.findElement(MobileBy.id(buttonId));  
	        return true;  
	    } catch (NoSuchElementException e) {  
	        return false;  
	    } finally {  
	        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);  
	    }  
	}

	public void clickForgotPwdLink() {
		Log.info("Clicking ForgotPassword Link");
		forgotPasswordLnk.click();
	}

	public void clickCreateAccntLink() {
		Log.info("Clicking Create Account Link");
		createAccntLnk.click();
	}
}
