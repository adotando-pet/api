package com.adopt.pet.domain.model.advertisement;

import com.adopt.pet.commons.enums.Status;
import com.adopt.pet.domain.model.address.Address;
import com.adopt.pet.domain.model.files.File;
import com.adopt.pet.domain.model.phone.Phone;

import java.time.LocalDate;
import java.util.List;

public class Advertisement {
    private long id;
    private String description;
    private Status status;
    private LocalDate createdDate;
    private LocalDate adoptionDate;
    private Address address;
    private List<Phone> phones;
    private List<File> files;

}
