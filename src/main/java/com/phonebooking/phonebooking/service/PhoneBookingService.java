package com.phonebooking.phonebooking.service;


import com.phonebooking.phonebooking.exception.PhoneAlreadyBookedException;
import com.phonebooking.phonebooking.model.Phone;
import com.phonebooking.phonebooking.repository.ItemRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class PhoneBookingService implements BookingService {

    private ItemRepository phoneRepository;

    public PhoneBookingService(ItemRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @Override
    public void bookItem(String phoneName, String bookedBy) throws PhoneAlreadyBookedException {

        Optional<Phone> optionalPhone = phoneRepository.findPhoneByName(phoneName);
        if (optionalPhone.isPresent()) {
            Phone phone = optionalPhone.get();
            synchronized (phone) {
                if (phone.isAvailable()) {
                    phone.setAvailable(false);
                    phone.setBookedBy(bookedBy);
                    phone.setLocalDateTime(LocalDateTime.now());
                    phoneRepository.updatePhone(phone);
                } else {
                    throw new PhoneAlreadyBookedException("Phone already booked");
                }
            }
        } else {
            throw new RuntimeException("Invalid Phone");
        }
    }

    @Override
    public void returnItem(String phoneName, String bookedBy) {

        Optional<Phone> optionalPhone = phoneRepository.findPhoneByName(phoneName);

        if (optionalPhone.isPresent()) {
            Phone phone = optionalPhone.get();

            if (!phone.isAvailable()) {
                phone.setAvailable(true);
                phone.setBookedBy(null);
                phoneRepository.updatePhone(phone);
            }
        } else {
            throw new RuntimeException("Invalid Phone");
        }

    }

    @Override
    public List<Phone> getAllItemStatus() {
        return phoneRepository.listAllPhones().stream().toList();
    }
}
