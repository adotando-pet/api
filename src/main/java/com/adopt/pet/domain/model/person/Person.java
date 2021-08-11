package com.adopt.pet.domain.model.person;

import com.adopt.pet.commons.enums.person.Gender;
import com.adopt.pet.domain.model.address.Address;
import com.adopt.pet.domain.model.files.File;
import com.adopt.pet.domain.model.phone.Phone;
import com.adopt.pet.domain.model.user.User;

import java.util.List;

public class Person {
    private long id;
    private Gender gender;
    private String documentNumber;
    private Address address;
    private User user;
    private File photo;
    private List<Phone> phones;
}
