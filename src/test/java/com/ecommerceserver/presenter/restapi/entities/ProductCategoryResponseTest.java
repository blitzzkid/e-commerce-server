package com.ecommerceserver.presenter.restapi.entities;

import com.ecommerceserver.core.domain.ProductCategory;
import com.ecommerceserver.core.entities.TestCoreEntityGenerator;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductCategoryResponseTest {

    @Test
    public void fromProductCategoryTest() {
        // Given
        ProductCategory productCategory = TestCoreEntityGenerator.randomProductCategory();

        // When
        ProductCategoryResponse actualProductCategoryResponse = ProductCategoryResponse.from(productCategory);

        // Then
        assertThat(actualProductCategoryResponse.getId()).isEqualTo(productCategory.getId().getNumber());
        assertThat(actualProductCategoryResponse.getName()).isEqualTo(productCategory.getName());
    }
}
