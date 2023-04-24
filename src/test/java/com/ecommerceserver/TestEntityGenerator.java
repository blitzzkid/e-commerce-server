package com.ecommerceserver;

import com.github.javafaker.Faker;

public final class TestEntityGenerator {

    private static final Faker faker = new Faker();
    public static Long randomId() {
        return faker.number().randomNumber();
    }
}
