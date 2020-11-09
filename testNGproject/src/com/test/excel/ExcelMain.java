package com.test.excel;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.pages.LoginPageObjects;

public class ExcelMain {

	static String folderPath= System.getProperty("user.dir");

	WebDriver driver=null;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/home/user/Desktop/Selenium/chromedriver_linux64/chromedriver");
		driver = new ChromeDriver();
	}

	@Test(dataProvider="Test1Data")
	public void test1(String username, String Password) throws InterruptedException {
		driver.get("http://10.1.10.110:89/mSathi");
		driver.manage().window().maximize();
		LoginPageObjects run = new LoginPageObjects(driver);
		Thread.sleep(1000);
		run.InputUsername(username);
		run.InputPassword(Password);

		run.DropdownSelect();
		run.ButtonLogin();
		Thread.sleep(1000);
		run.ButtonAppMenu();
		run.ButtonLogOut();

	}
	@DataProvider(name = "Test1Data")
	public Object[][] getData() throws IOException {
		Object data[][]= testData();
		return data;
	}


	public static Object[][] testData() throws IOException {

		ExcelRef exc = new ExcelRef(folderPath+"/ExcelFile/Untitled spreadsheet.xlsx", "Sheet1");

		int Raw= exc.getRawCount();
		int Cols=  exc.getColCount();
		Object excdata[][]= new Object[Raw-1][Cols];
		for (int i = 1; i < Raw; i++) {
			for (int j = 0; j <Cols; j++) {
				String data =exc.getStringData(i, j);
				System.out.print(data+" ");
				excdata[i-1][j]= data;
			}
			System.out.println();
		}
		return excdata;

	}

}
