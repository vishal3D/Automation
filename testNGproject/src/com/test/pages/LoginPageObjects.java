package com.test.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {
	WebDriver driver=null;
	public LoginPageObjects(WebDriver driver) {
		this.driver= driver;
	}
	By textBox_UserName= By.xpath("//input[@id='loginform-username']");
	By textBox_password= By.id("loginform-password");
	By dropdown_select = By.xpath("//b[@role='presentation']");
	By button_login	= By.xpath("//button[@id='login-button']");
	By button_AppMenu 	= By.xpath("//div[@class='user-menu']//img[@class='img-responsive img-user']");
	By button_LogOut	= By.xpath("//ul[@class='dropdown-menu dropdown-menu-user']//li[@class='text-center li-logout']//button[@id='logout']");

	public void InputUsername(String input) {
		driver.findElement(textBox_UserName).sendKeys(input);
	}
	public void InputPassword(String input) {
		driver.findElement(textBox_password).sendKeys(input);
	}
	public void DropdownSelect() {
		driver.findElement(dropdown_select).click();
		List <WebElement> opt = driver.findElements(By.xpath("//ul[@role='tree']//li[@class='select2-results__option']"));

		for (int i = 0; i < opt.size(); i++) {
			if(opt.get(i).getText().contains("Gupta Computers (GCOMP)")) {
				opt.get(i).click();
				break;
			}
		}
	}

	public void ButtonLogin() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(button_login).click();	
	}
	public void ButtonAppMenu() throws InterruptedException {
		Thread.sleep(1500); 
		driver.findElement(button_AppMenu).click();
	}
	public void ButtonLogOut() throws InterruptedException {
		
		Thread.sleep(1000);
		
		driver.findElement(button_LogOut).click();
		Thread.sleep(1000);
		

	}
}
