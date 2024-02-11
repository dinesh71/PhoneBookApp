package com.phonebooking.phonebooking;

import com.phonebooking.phonebooking.exception.PhoneAlreadyBookedException;
import com.phonebooking.phonebooking.model.Phone;
import com.phonebooking.phonebooking.service.BookingFactory;
import com.phonebooking.phonebooking.service.BookingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;


class PhonebookingApplicationTests {

	@Test
	void test_valid_booking_return() throws PhoneAlreadyBookedException {
		BookingFactory bookingFactory = new BookingFactory();
		BookingService phoneBookingService = bookingFactory.getService("PHONE");

		phoneBookingService.bookItem("APPLE_IPHONE_12", "1234");

		phoneBookingService.bookItem("IPHONE_X", "1234");

		phoneBookingService.bookItem("MOTOROLA_NEXUS_6", "1234");

		phoneBookingService.returnItem("IPHONE_X", "1234");


		List<Phone> allItemStatus = phoneBookingService.getAllItemStatus();

		Optional<Phone> optionalPhone = allItemStatus.stream()
				.filter(phone -> phone.getModal().equals("APPLE_IPHONE_12")).findFirst();

		Assertions.assertEquals("1234", optionalPhone.get().getBookedBy());

		optionalPhone = allItemStatus.stream()
				.filter(phone -> phone.getModal().equals("IPHONE_X")).findFirst();

		Assertions.assertEquals(null, optionalPhone.get().getBookedBy());

	}



	@Test
	void test_valid_booking_exception() {
		Assertions.assertThrows(PhoneAlreadyBookedException.class, () -> {
			BookingFactory bookingFactory = new BookingFactory();
			BookingService phoneBookingService = bookingFactory.getService("PHONE");

			phoneBookingService.bookItem("APPLE_IPHONE_12", "1234");
			phoneBookingService.bookItem("APPLE_IPHONE_12", "1234");
		});

	}

}
