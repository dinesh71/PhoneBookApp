package com.phonebooking.phonebooking.service;

import com.phonebooking.phonebooking.repository.InMemoryPhoneRepository;
import com.phonebooking.phonebooking.repository.ItemRepository;

public class BookingFactory {

    public BookingService getService(String item) {
        if(item == null){
            return null;
        }
        if(item.equalsIgnoreCase("PHONE")){
            ItemRepository itemRepository = new InMemoryPhoneRepository();
            return  new PhoneBookingService(itemRepository);
        }

        return null;
    }
}
