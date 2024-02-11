package com.phonebooking.phonebooking;

import com.phonebooking.phonebooking.exception.PhoneAlreadyBookedException;
import com.phonebooking.phonebooking.model.Phone;
import com.phonebooking.phonebooking.repository.InMemoryPhoneRepository;
import com.phonebooking.phonebooking.repository.ItemRepository;
import com.phonebooking.phonebooking.service.BookingFactory;
import com.phonebooking.phonebooking.service.BookingService;
import com.phonebooking.phonebooking.service.PhoneBookingService;

import java.util.List;

public class PhonebookingApplication {

	public static void main(String[] args) throws PhoneAlreadyBookedException {

		BookingService phoneBookingService = getBookingService();

		List<Phone> allItemStatus = phoneBookingService.getAllItemStatus();

		allItemStatus.forEach(System.out::println);

		phoneBookingService.bookItem("APPLE_IPHONE_12", "1234");

		phoneBookingService.bookItem("IPHONE_X", "1234");

		phoneBookingService.bookItem("MOTOROLA_NEXUS_6", "1234");

		phoneBookingService.returnItem("IPHONE_X", "1234");

		allItemStatus.forEach(System.out::println);

	}

	private static BookingService getBookingService() {
		BookingFactory bookingFactory = new BookingFactory();
		return bookingFactory.getService("PHONE");
	}


}
