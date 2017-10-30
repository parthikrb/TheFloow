package thefloow.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TermsPage {

String buttonId = "com.thefloow.flo:id/btn_agree";
	@AndroidFindBy(id = "com.thefloow.flo:id/btn_agree")
	public MobileElement iAgreeBtn;

	public AndroidDriver<AndroidElement> driver;

	public TermsPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	public boolean isTermsBtnPresent(AndroidDriver<AndroidElement> driver) {  
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

	public void acceptTerms() {
		iAgreeBtn.click();
	}

}
