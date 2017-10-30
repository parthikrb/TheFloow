package thefloow.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WelcomeScreenPage {
	
	@AndroidFindBy(id = "com.thefloow.flo:id/btn_welcome_close")
	public MobileElement closePopupBtn;
	
	@AndroidFindBy(id = "com.thefloow.flo:id/btn_welcome_start")
	public MobileElement startBtn;
	
	public AndroidDriver<AndroidElement> driver;

	public WelcomeScreenPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickClosePopupBtn() {
		closePopupBtn.click();
	}

}
