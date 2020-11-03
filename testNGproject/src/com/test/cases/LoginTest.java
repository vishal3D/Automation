package com.test.cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.pages.LoginPageObjects;

public class LoginTest {
	static WebDriver driver= null;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/home/user/Desktop/Selenium/chromedriver_linux64/chromedriver");
		driver = new ChromeDriver();
	}
	@Test
	public void Login() throws InterruptedException {

		driver.get("http://10.1.10.110:89/mSathi");
		LoginPageObjects run = new LoginPageObjects(driver);

		run.InputUsername("Abhishek");
		run.InputPassword("Admin@123");
		run.DropdownSelect();
		run.ButtonLogin();
		run.ButtonAppMenu();
		run.ButtonLogOut();


	}

}
