package com.codementoring.ecommerceserver.core.entities;

import com.codementoring.ecommerceserver.core.domain.Identity;
import com.codementoring.ecommerceserver.core.domain.ProductCategory;
import com.github.javafaker.Faker;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class TestCoreEntityGenerator {
    private static final Faker faker = new Faker();

    private static int randomNumberBetweenFiveAndTen() {
        return faker.number().numberBetween(5, 10);
    }

    private static <T> List<T> randomItemsOf(Supplier<T> generator) {
        return IntStream.rangeClosed(0, randomNumberBetweenFiveAndTen())
                .mapToObj(number -> (T) generator.get())
                .collect(Collectors.toList());
    }

    public static Identity randomId() {
        return new Identity(faker.number().randomNumber());
    }

    public static ProductCategory randomProductCategory() {
        return new ProductCategory(randomId(), faker.name().name());
    }

    public static List<ProductCategory> randomProductCategories() {
        return randomItemsOf(TestCoreEntityGenerator::randomProductCategory);
    }
}
