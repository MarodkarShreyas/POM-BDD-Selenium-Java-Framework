package com.stepdefinations;

import com.factory.DriverFactory;
import com.pages.BookingInfoPage;

import io.cucumber.java.en.Then;

public class BookingInfoPageSteps {

	private BookingInfoPage bookingInfoPage = new BookingInfoPage(DriverFactory.getDriver());

	@Then("Handle the pop ups and click on cancel booking")
	public void Handle_the_pop_ups_and_click_on_cancel_booking() {
		bookingInfoPage.clickCancelBooking();
	}

	@Then("Capture the cancellation number and write it to a csv file")
	public void Capture_the_cancellation_number_and_write_it_to_a_csv_file() {
		bookingInfoPage.confirmBookingCancellation();
		bookingInfoPage.saveCancellationNumber();
	}
}
