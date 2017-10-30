package thefloow.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import thefloow.utils.Log;

public class Menu {

	@AndroidFindBy(id = "com.thefloow.flo:id/tab_home")
	public MobileElement homeMenu;

	@AndroidFindBy(id = "com.thefloow.flo:id/tab_journeys")
	public MobileElement journeyMenu;

	@AndroidFindBy(id = "com.thefloow.flo:id/tab_score")
	public MobileElement scoreMenu;

	@AndroidFindBy(id = "com.thefloow.flo:id/tab_social")
	public MobileElement socialMenu;

	@AndroidFindBy(id = "com.thefloow.flo:id/tab_help")
	public MobileElement helpMenu;

	public AndroidDriver<AndroidElement> driver;

	public Menu(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void openHomeMenu(){
		Log.info("Opening Home Menu");
		homeMenu.click();
	}
	
	public void openJourneyMenu() {
		Log.info("Opening Journey Menu");
		journeyMenu.click();
	}
	
	public void openScoreMenu() {
		Log.info("Opening Score Menu");
		scoreMenu.click();
	}
	
	public void openSocialMenu() {
		Log.info("Opening Social Menu");
		socialMenu.click();
	}
	
	public void openHelpMenu() {
		Log.info("Opening Help Menu");
		helpMenu.clear();
	}

}