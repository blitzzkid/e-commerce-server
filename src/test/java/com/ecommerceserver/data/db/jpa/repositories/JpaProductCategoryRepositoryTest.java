package com.ecommerceserver.data.db.jpa.repositories;

import com.ecommerceserver.data.db.jpa.entities.ProductCategoryData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaProductCategoryRepositoryTest {

    @Autowired
    private JpaProductCategoryRepository jpaProductCategoryRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Configuration
    @AutoConfigurationPackage
    @EntityScan("com.ecommerceserver.data.db.jpa.entities")
    static class Config {
    }

    @Test
    public void findByNameIgnoreCaseTest() {
        // Given
        Arrays.stream(new String[]{"aAbc", "abCc", "aBbc"})
                .forEach(name -> testEntityManager.persistAndFlush(ProductCategoryData.newInstance(name)));

        // When
        final List<ProductCategoryData> actualProductCategoryData = jpaProductCategoryRepository.findByNameContainingIgnoreCase("abc");

        // Then
        assertThat(actualProductCategoryData)
                .extracting("name")
                .containsOnly("aAbc", "abCc");
    }
}
