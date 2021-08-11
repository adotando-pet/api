package com.adopt.pet.domain.model.pet;

import com.adopt.pet.commons.enums.person.Gender;
import com.adopt.pet.domain.model.files.File;
import com.adopt.pet.domain.model.person.Person;
import com.adopt.pet.domain.model.person.Size;

import java.time.LocalDate;
import java.util.List;

public class Pet {
    private long id;
    private String name;
    private Gender gender;
    private int age;
    private List<Color> colors;
    private String breed;
    private boolean isNeutered;
    private boolean isVaccinated;
    private List<Vaccine> vaccines;
    private Size size;
    private LocalDate registerDate;
    private Person person;
    private boolean isDisabled;
    private String disabledDescription;
    private boolean specialCare;
    private String specialCareDescription;
    private List<LiveWell> liveWells;
    private List<Sociable> sociables;
    private List<Temperament> temperaments;
    private List<File> photos;
}
