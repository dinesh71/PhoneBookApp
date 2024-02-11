package com.phonebooking.phonebooking.service;

import com.phonebooking.phonebooking.exception.PhoneAlreadyBookedException;
import com.phonebooking.phonebooking.model.Phone;

import java.util.List;

public interface BookingService {


    void bookItem(String phoneName, String bookedBy) throws PhoneAlreadyBookedException;

    public void returnItem(String phoneName, String returnedBy);

    public List<Phone> getAllItemStatus();

}
