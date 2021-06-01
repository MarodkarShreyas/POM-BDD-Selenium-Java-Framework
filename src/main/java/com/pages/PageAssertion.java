package com.pages;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.WebElement;

import com.util.CommonUtil;

//Overloading Example

public class PageAssertion extends CommonUtil{

	public void verifyText(WebElement element, String expectedText) {
		Asserts.check(element.getText().contains(expectedText), "Text matching");
	}

	public void verifyText(String expectedText, String actualText) {
		Asserts.check(actualText.contains(expectedText), "Text matching");
	}
}
