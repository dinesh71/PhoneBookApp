package com.phonebooking.phonebooking.repository;

import com.phonebooking.phonebooking.model.Phone;
import com.phonebooking.phonebooking.model.PhoneEnum;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
public class InMemoryPhoneRepository implements ItemRepository {

    Map<String, Phone> phoneMap = new ConcurrentHashMap<>();

    /**
     *
     */
    public InMemoryPhoneRepository() {

        PhoneEnum[] values = PhoneEnum.values();
        long id = 0;
        for (PhoneEnum pe : values) {
            Phone p = new Phone();
            p.setAvailable(true);
            p.setId(++id);
            p.setModal(pe.name());
            phoneMap.put(pe.name(), p);
        }
    }

    public Collection<Phone> listAllPhones() {
        return phoneMap.values();
    }

    public Optional<Phone> findPhoneByName(String phoneName) {
        return Optional.ofNullable(phoneMap.get(phoneName));
    }

    public void updatePhone(Phone p) {

        if (phoneMap.get(p.getModal()) != null) {
            phoneMap.put(p.getModal(), p);
        }

    }
}
