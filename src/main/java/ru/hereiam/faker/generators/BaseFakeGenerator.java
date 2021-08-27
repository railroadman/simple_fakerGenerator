package ru.hereiam.faker.generators;

import com.github.javafaker.Faker;

public class BaseFakeGenerator {

    private Faker faker;


    public BaseFakeGenerator() {

        this.faker = new Faker();


    }
}
