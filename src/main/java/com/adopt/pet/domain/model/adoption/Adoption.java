package com.adopt.pet.domain.model.adoption;

import com.adopt.pet.commons.enums.Status;
import com.adopt.pet.domain.model.advertisement.Advertisement;
import com.adopt.pet.domain.model.person.Person;

import java.time.LocalDate;

public class Adoption {
    private long id;
    private Person owner;
    private Advertisement advertisement;
    private Person interestedPerson;
    private Status status;
    private LocalDate contactDate;
}
