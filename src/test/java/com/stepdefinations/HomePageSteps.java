package com.stepdefinations;

import com.factory.DriverFactory;
import com.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import org.junit.Assert;

public class HomePageSteps {

	private static String title;
	private HomePage homePage = new HomePage(DriverFactory.getDriver());

	@Given("User is on the home page and validate page title as {string}")
	public void User_is_on_the_home_page_and_validate_page_title_as(String expectedTitleName) {
		title = homePage.getPageTitle();
		System.out.println("Page title is : " + title);
		Assert.assertTrue(title.contains(expectedTitleName));
	}

	@When("User click manage booking")
	public void user_click_manage_booking() {
		homePage.clickOnManageBooking();
	}

	@When("Load the booking detail as {string} and {string} and {string} and clcik search")
	public void load_the_booking_detail_as_and_and_and_clcik_search(String ref, String surname, String date) {
		homePage.enterBookingDetail(ref, surname, date);
		homePage.clickSearchButton();
	}
}
