package thefloow.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import thefloow.utils.Log;

public class HomePage {
	
	@AndroidFindBy(id = "com.thefloow.flo:id/btn_start")
	public MobileElement startBtn;

	@AndroidFindBy(id = "com.thefloow.flo:id/btn_acquiring_gps")
	public MobileElement acqGPSBtn;

	@AndroidFindBy(id = "com.thefloow.flo:id/btn_cancel_gps")
	public MobileElement cancelBtn;

	@AndroidFindBy(id = "com.thefloow.flo:id/btn_feedback")
	public MobileElement feedbackBtn;
	
	@AndroidFindBy(id = "com.thefloow.flo:id/btn_emergency")
	public MobileElement emergencyBtn;

	@AndroidFindBy(id = "com.thefloow.flo:id/chrono_duration")
	public MobileElement durationText;

	@AndroidFindBy(id = "com.thefloow.flo:id/text_view_mileage")
	public MobileElement mileageText;
	
	public AndroidDriver<AndroidElement> driver;

	public HomePage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickStartBtn() throws InterruptedException {
		Log.info("Clicking Start Button");
		startBtn.click();
		Log.info("Waiting for the App to Start");
		Thread.sleep(2000);
		Log.info("Validation of Start Button functions...");
		assert(acqGPSBtn.isDisplayed());
		assert(cancelBtn.isDisplayed());
	}

}
