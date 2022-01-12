package com.restDeneme.resDeneme.model;

import com.github.javafaker.Faker;

import java.util.Set;

public class KurumGetir {
    Faker faker = new Faker();

    String id = faker.app().name();
    String owner = faker.name().firstName();
    String logo = faker.app().name();
    String kurumAdi = faker.name().username();


}
