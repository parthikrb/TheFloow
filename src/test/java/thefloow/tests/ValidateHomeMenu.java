package thefloow.tests;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import thefloow.pages.HomePage;
import thefloow.pages.LoginPage;
import thefloow.pages.TermsPage;
import thefloow.pages.WelcomeScreenPage;
import thefloow.utils.EnvironmentSetup;
import thefloow.utils.Log;
import thefloow.utils.PropertyParser;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class ValidateHomeMenu {
	static AndroidDriver<AndroidElement> driver;
	static TermsPage tp;
	static LoginPage lp;
	static WelcomeScreenPage wsp;
	static HomePage hp;
	static PropertyParser p;

	@Test
	public static void f() throws Exception {
		Thread.sleep(2000);
		if (!tp.isTermsBtnPresent(driver)) {
			if (!lp.isLogInBtnPresent(driver)) {
				Log.info("App is already Logged In!");
				Log.info("Clicking Start button");
				hp.clickStartBtn();
			} else {
				Log.info("Logging into App...");
				lp.logInToApp(p.eMail, p.password);
				Thread.sleep(10000);
				wsp.clickClosePopupBtn();
				Thread.sleep(2000);
				Log.info("Clicking Start button");
				hp.clickStartBtn();
			}
		} else {
			Log.info("Accepting Terms and Conditions");
			tp.acceptTerms();
			Thread.sleep(2000);
			f();
		}

	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		tp = new TermsPage(driver);
		lp = new LoginPage(driver);
		wsp = new WelcomeScreenPage(driver);
		hp = new HomePage(driver);
		p = new PropertyParser();
	}

	@BeforeTest
	public void beforeTest() throws IOException {
		Log.startTestCase("Start of Home Menu Validation Test");
		driver = EnvironmentSetup.loadApp();
		return;
	}
	
	@AfterTest
	public void afterTest() {
		Log.info("Closing the App");
		Log.endTestCase();
		driver.quit();
	}


}
