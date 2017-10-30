package thefloow.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class EnvironmentSetup {
	static AndroidDriver<AndroidElement> driver;

	public static AndroidDriver<AndroidElement> loadApp() throws IOException {
		Log.info("Setting up Environment Varialbles");
		PropertyParser p = new PropertyParser();
		// Path to the APK File
		File appDir = new File(p.apkPath);
		File app = new File(appDir, p.apkName);
		// To create an object of Desired Capabilities
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability("appPackage", p.appPackage);
		capabilities.setCapability("appActivity", p.appActivity);
		capabilities.setCapability("autoAcceptAlerts", true);
		capabilities.setCapability("locationServicesAuthorized", true);
		Log.info("Loading App...");
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.className("android.widget.LinearLayout")));
		return driver;
	}

}
