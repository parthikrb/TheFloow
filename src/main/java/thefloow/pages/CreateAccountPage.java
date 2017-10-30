package thefloow.pages;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import thefloow.utils.Log;

public class CreateAccountPage {

	@AndroidFindBy(id = "com.thefloow.flo:id/edit_text_first_name")
	static MobileElement firstNameFld;

	@AndroidFindBy(id = "com.thefloow.flo:id/edit_text_surname")
	static MobileElement surNameFld;

	@AndroidFindBy(id = "com.thefloow.flo:id/edit_text_date_of_birth")
	static MobileElement dataOfBirthFld;

	@AndroidFindBy(id = "com.thefloow.flo:id/edit_text_email")
	static MobileElement eMaidTxtFld;

	@AndroidFindBy(id = "com.thefloow.flo:id/edit_text_postcode")
	static MobileElement postCodeTxtFld;

	@AndroidFindBy(id = "com.thefloow.flo:id/edit_text_company_name")
	static MobileElement compNameTxtFld;

	@AndroidFindBy(id = "com.thefloow.flo:id/edit_text_password")
	static MobileElement chsePasswordTxtFld;

	@AndroidFindBy(id = "com.thefloow.flo:id/edit_text_confirm_password")
	static MobileElement cnfrmPasswordTxtFld;

	@AndroidFindBy(id = "com.thefloow.flo:id/button_register")
	MobileElement submitBtn;

	@AndroidFindBy(id = "android:id/button1")
	static MobileElement dateOKBtn;

	@AndroidFindBy(id = "android:id/button2")
	MobileElement dateCancelBtn;

	@AndroidFindBy(id = "android:id/numberpicker_input")
	static List<MobileElement> datePicker;

	private AppiumDriver<AndroidElement> driver;

	public CreateAccountPage(AppiumDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void createAccnt(String fName, String sName, String eMail, String postcode, String compName, String password,
			String birthDate, String birthMonth, String birthYear) {
		Log.info("Passing value to FirstName: " + fName);
		firstNameFld.sendKeys(fName);
		Log.info("Passing value to SurName: " + sName);
		surNameFld.sendKeys(sName);
		Log.info("Passing value to DOB: " + birthMonth + "-" + birthDate + "-" + birthYear);
		selectDOB(birthMonth, birthDate, birthYear);
		Log.info("Passing value to eMail: " + eMail);
		eMaidTxtFld.sendKeys(eMail);
		Log.info("Passing value to PostCode: " + postcode);
		postCodeTxtFld.sendKeys(String.valueOf(postcode));
		Log.info("Passing value to Company Name:" + compName);
		compNameTxtFld.sendKeys(compName);
		Log.info("Hiding Keyboard");
		driver.hideKeyboard();
		Log.info("Passing value to Password: " + password);
		chsePasswordTxtFld.sendKeys(password);
		Log.info("Hiding Keyboard");
		Log.info("Passing value to Confirm Password: " + password);
		driver.hideKeyboard();
		cnfrmPasswordTxtFld.sendKeys(password);
		Log.info("Hiding Keyboard");
		driver.hideKeyboard();
		submitBtn.click();

	}

	public static void selectDOB(String birthDate, String birthMonth, String birthYear) {
		dataOfBirthFld.click();
		datePicker.get(0).clear();
		datePicker.get(0).sendKeys(birthMonth);
		datePicker.get(1).clear();
		datePicker.get(1).sendKeys(birthDate);
		datePicker.get(2).clear();
		datePicker.get(2).sendKeys(birthYear);
		dateOKBtn.click();
	}
}
