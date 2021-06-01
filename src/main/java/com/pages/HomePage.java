package com.pages;

import java.time.Month;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageAssertion {
	// 1. By Locators : OR
	@FindBy(id = "log-in")
	private WebElement logInBtn;

	@FindBy(id = "find-a-booking")
	private WebElement manageBookingBtn;

	@FindBy(id = "booking-reference-input")
	private WebElement bookingReferenceInput;

	@FindBy(id = "booking-surname-input")
	private WebElement bookingSurnameInput;

	@FindBy(xpath = "//*[contains(text(), 'Arrival date')]/../input")
	private WebElement arrivalDateCalendar;

	@FindBy(xpath = "(//*[@class='calendar-chevron date-picker-right-arrow'])[2]")
	private WebElement calendarArrowRight;

	@FindBy(xpath = "(//div[@class='calendar-heading'])[2]")
	private WebElement datePickerHeader;

	@FindBy(id = "find-booking-form-button")
	private WebElement findBookingFormButton;

	// 2. Constructor of the page class
	public HomePage(WebDriver driver) {
		PageFactory.initElements(getDriver(), this);
	}

	// 3. Page Actions: Feature (behavior) of the page
	public String getPageTitle() {
		return getDriver().getTitle();
	}

	public void clickOnManageBooking() {
		manageBookingBtn.click();
	}

	public void enterBookingDetail(String bookingRef, String bookingSurname, String arrivalDate) {
		bookingReferenceInput.sendKeys(bookingRef);
		bookingSurnameInput.sendKeys(bookingSurname);
		arrivalDateCalendar.click();
		selectDate(arrivalDate);
	}

	public void selectDate(String givenDate) {
		String[] givenDayMonthYear = givenDate.split("-");

		if (givenDayMonthYear[1].equals("Feb") && Integer.parseInt(givenDayMonthYear[0]) > 29) {
			System.out.println("Invalid Date provided : " + givenDate);
		}

		if (Integer.parseInt(givenDayMonthYear[0]) > 31) {
			System.out.println("Invalid Date provided :  " + givenDate);
		}

		String currentMonthYearVal = datePickerHeader.getText();

		while (!(currentMonthYearVal.split(" ")[0].equals(givenDayMonthYear[1])
				&& currentMonthYearVal.split(" ")[1].equals("20" + (givenDayMonthYear[2])))) {
			calendarArrowRight.click();
			currentMonthYearVal = datePickerHeader.getText();
		}

		try {
			String dateId = "date-picker-day-" + givenDayMonthYear[0] + getMonthNumber(givenDayMonthYear[1]) + "20"
					+ (givenDayMonthYear[2]);
			getDynamicElementxpath("//button[@id='" + dateId + "']").click();
		} catch (Exception e) {
			System.out.println("Invalid Date provided : " + givenDate);
		}
	}

	private int getMonthNumber(String monthName) {
		return Month.valueOf(monthName.toUpperCase()).getValue();
	}

	public void clickSearchButton() {
		findBookingFormButton.click();
	}

	// Overriding
	public void verifyText(WebElement element, String expectedText) {
		Asserts.check(element.getText().contains(expectedText), "Text matched on home page");
	}

}
