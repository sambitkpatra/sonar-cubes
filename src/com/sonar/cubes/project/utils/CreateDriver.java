package com.sonar.cubes.project.utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.sonar.cubes.utils.GetData;

public class CreateDriver {
	
	public static WebDriver getDriver()
	{
		WebDriver driver = null;
		String browsername = GetData.fromProperties("config","browser");
		String URL = GetData.fromProperties("config", "url");
		if (browsername.equalsIgnoreCase("ff"))
			{
			System.setProperty("webdriver.gecko.driver","./browser_server/geckodriver.exe");
			driver = new FirefoxDriver();
			}
		else if (browsername.equalsIgnoreCase("GC"))
			{
		System.setProperty("webdriver.chrome.driver", "./browser_server/chromedriver.exe");
		driver = new ChromeDriver();
			}
		else
		{
		System.out.println("Invalid Browser name");	
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(URL);
		return driver;
		}
	
}















