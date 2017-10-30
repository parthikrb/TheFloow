package thefloow.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyParser {

	private FileInputStream stream;
	private String RepositoryFile;
	private static Properties propFile = new Properties();
	public String apkPath;
	public String apkName;
	public String deviceName;
	public String deviceVersion;
	public String appPackage;
	public String appActivity;
	public String createAccntFName;
	public String createAccntSName;
	public String eMail;
	public String postcode;
	public String compName;
	public String password;
	public String birthDate;
	public String birthYear;
	public String birthMonth;

	public PropertyParser() throws IOException {
		this.RepositoryFile = "ObjectRepo.properties";
		stream = new FileInputStream(RepositoryFile);
		propFile.load(stream);
		apkPath = propFile.getProperty("apkLocation");
		apkName = propFile.getProperty("apkName");
		// deviceName = propFile.getProperty("deviceName");
		// deviceVersion = propFile.getProperty("deviceVersion");
		appPackage = propFile.getProperty("appPackage");
		appActivity = propFile.getProperty("appActivity");
		createAccntFName = propFile.getProperty("createAcFName");
		createAccntSName = propFile.getProperty("createAccntSName");
		eMail = propFile.getProperty("eMail");
		postcode = propFile.getProperty("postcode");
		compName = propFile.getProperty("compName");
		password = propFile.getProperty("password");
		birthDate = propFile.getProperty("birthDate");
		birthYear = propFile.getProperty("birthYear");
		birthMonth = propFile.getProperty("birthMonth");
		return;

	}

}
