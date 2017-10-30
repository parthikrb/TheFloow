package thefloow.tests;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import thefloow.pages.CreateAccountPage;
import thefloow.pages.LoginPage;
import thefloow.pages.TermsPage;
import thefloow.utils.EnvironmentSetup;
import thefloow.utils.Log;
import thefloow.utils.PropertyParser;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class CreateAccountTest {
	static AndroidDriver<AndroidElement> driver;
	static TermsPage tp;
	static LoginPage lp;
	static CreateAccountPage cap;
	static PropertyParser p;

	@Test
	public void f() throws InterruptedException {
		Log.info("Waiting for the screen to load");
		Thread.sleep(5000);
		if (!tp.isTermsBtnPresent(driver)) {
			lp.clickCreateAccntLink();
			cap.createAccnt(p.createAccntFName, p.createAccntSName, p.eMail, p.postcode, p.compName, p.password,
					p.birthDate, p.birthMonth, p.birthYear);
		} else {
			tp.acceptTerms();
			f();
		}
	}

	@BeforeTest
	public void beforeTest() throws IOException {
		Log.startTestCase("Start of Create Account Test");
		driver = EnvironmentSetup.loadApp();
		return;

	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		tp = new TermsPage(driver);
		lp = new LoginPage(driver);
		cap = new CreateAccountPage(driver);
		p = new PropertyParser();
	}
	
	@AfterTest
	public void afterTest() {
		Log.info("Closing the App");
		Log.endTestCase();
		driver.quit();
	}

}
