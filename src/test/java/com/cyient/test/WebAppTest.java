package com.cyient.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class WebAppTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// platform name
		// browser name
		// device name

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("platformName	", "Android");
		cap.setCapability("deviceName", "redmi");
		cap.setCapability("browserName", "Chrome");
		cap.setCapability("chromedriverExecutable",
				"C:\\study\\Automation_Testing\\component\\chromedriver_win32\\chromedriver.exe");

		// send DesiredCapabilities to appium server
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://magento.com/");

		driver.findElement(By.xpath("//span[contains(text(),'Sign in')]")).click();

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("balaji0017@gmail.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("balaji@12345");
		Thread.sleep(5000);
		if (driver.isKeyboardShown()) {
			driver.hideKeyboard();
		}
		driver.findElementByXPath("//div[@class='login-form__bottom']//button[@id='send2']").click();

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[text()='Log Out']")));

		driver.findElement(By.xpath("//a[text()='Log Out']")).click();

	}
}
