#Author: Shreyas.Marodkar
#Keywords Summary :
#Feature: Search for available booking
#Scenario: Cancel the booking and store cancellation number
Feature: Booking cancellation

  Scenario Outline: : User search for booking and cancel
    Given User is on the home page and validate page title as "Premier Inn hotels | Book direct"
    When User click manage booking
    And Load the booking detail as "<BookingReference>" and "<BookingSurname>" and "<ArrivalDate>" and clcik search
    Then Handle the pop ups and click on cancel booking
    And Capture the cancellation number and write it to a csv file

    Examples: 
      | BookingReference | BookingSurname | ArrivalDate  |
      | BBYR328918       | Auto           | 24-August-21 |
