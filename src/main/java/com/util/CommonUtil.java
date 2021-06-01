package com.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.factory.DriverFactory;

public class CommonUtil extends DriverFactory{

	public void waitForElementToLoad(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element));
	}
	
	public void bringElementInView(WebDriver driver, WebElement element) {
		WebElement viewElement = element;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewElement);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public WebElement getDynamicElementxpath(String xpath) {
		return getDriver().findElement(By.xpath(xpath));
	}
}
