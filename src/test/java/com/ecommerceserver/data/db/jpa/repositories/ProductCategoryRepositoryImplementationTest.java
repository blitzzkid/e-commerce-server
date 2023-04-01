package com.ecommerceserver.data.db.jpa.repositories;

import com.ecommerceserver.core.domain.ProductCategory;
import com.ecommerceserver.core.entities.TestCoreEntityGenerator;
import com.ecommerceserver.data.db.jpa.entities.ProductCategoryData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class ProductCategoryRepositoryImplementationTest {

    @Mock
    private JpaProductCategoryRepository jpaProductCategoryRepository;

    @InjectMocks
    private ProductCategoryRepositoryImplementation productCategoryRepositoryImplementation;

    @Test
    public void getAllProductCategoriesTest() {
        // Given
        ProductCategory productCategory = TestCoreEntityGenerator.randomProductCategory();
        ProductCategoryData productCategoryData = ProductCategoryData.from(productCategory);

        doReturn(Collections.singletonList(productCategoryData))
                .when(jpaProductCategoryRepository)
                .findAll();

        // When
        final List<ProductCategory> actualListOfProductCategories = productCategoryRepositoryImplementation.getAllProductCategories();

        // Then
        assertThat(actualListOfProductCategories).contains(productCategory);
    }

    @Test
    public void searchProductCategoryByNameTest() {
        // Given
        ProductCategory productCategory = TestCoreEntityGenerator.randomProductCategory();
        ProductCategoryData productCategoryData = ProductCategoryData.from(productCategory);
        String searchText = "abc";

        doReturn(Collections.singletonList(productCategoryData))
                .when(jpaProductCategoryRepository)
                .findByNameContainingIgnoreCase(searchText);
        // When
        final List<ProductCategory> actualListOfProductCategories = productCategoryRepositoryImplementation.searchProductCategoryByName(searchText);

        // Then
        assertThat(actualListOfProductCategories).isEqualTo(Collections.singletonList(productCategory));
    }
}
