package com.phonebooking.phonebooking.repository;

import com.phonebooking.phonebooking.model.Phone;

import java.util.Collection;
import java.util.Optional;

/**
 *
 */
public interface ItemRepository {

    /**
     * List All Phones
     * @return
     */
    public Collection<Phone> listAllPhones();

    /**
     * Return Phone By Name
     * @param phoneName
     * @return
     */

    public Optional<Phone> findPhoneByName(String phoneName);

    /**
     * update Phone status
     * @param p
     */
    public void updatePhone(Phone p);
}
