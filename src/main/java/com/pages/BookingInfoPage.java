package com.pages;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.opencsv.CSVWriter;

public class BookingInfoPage extends PageAssertion {

	// 1. By Locators : OR
	@FindBy(xpath = "//button[text()='Cancel booking']")
	private WebElement cancelBookingBtn;

	@FindBy(xpath = "(//button[text()='Cancel booking'])[2]")
	private WebElement confirmBookingCancel;

	@FindBy(xpath = "(//div[@data-test-id='cancel-success-notification']//span[1])[2]")
	private WebElement cancellationNumber;

	// 2. Constructor of the page class
	public BookingInfoPage(WebDriver driver) {
		PageFactory.initElements(getDriver(), this);
	}

	// 3. Page Actions: Feature (behavior) of the page
	public void clickCancelBooking() {
		cancelBookingBtn.click();
	}

	public void confirmBookingCancellation() {
		confirmBookingCancel.click();
	}

	public void saveCancellationNumber() {
		String cancellation_Number = cancellationNumber.getText();
		System.out.println("cancellation_Number: " + cancellation_Number);
		writeToCSVFile(cancellation_Number);
	}

	public static void writeToCSVFile(String number) {
		String[] cancellationId = { "CancellationId", number };
		try (CSVWriter writer = new CSVWriter(new FileWriter(".\\target\\cancellationNumberOpenCSV.csv", true))) {
			writer.writeNext(cancellationId);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Overriding
	public void verifyText(WebElement element, String expectedText) {
		Asserts.check(element.getText().contains(expectedText), "Text matched on booking info page");
	}
}
