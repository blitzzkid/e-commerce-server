package com.codementoring.ecommerceserver.core.usecases.productcategory;

import com.codementoring.ecommerceserver.core.domain.ProductCategory;
import com.codementoring.ecommerceserver.core.entities.TestCoreEntityGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class GetAllProductCategoriesUseCaseTest {
    @InjectMocks
    private GetAllProductCategoriesUseCase getAllProductCategoriesUseCase;

    @Mock
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void returnAllProductCategories() {
        // Given
        List<ProductCategory> productCategories = TestCoreEntityGenerator.randomProductCategories();
        GetAllProductCategoriesUseCase.InputValues input = new GetAllProductCategoriesUseCase.InputValues();

        doReturn(productCategories)
                .when(productCategoryRepository)
                .getAllProductCategories();

        // When
        final List<ProductCategory> actualListOfProductCategories = getAllProductCategoriesUseCase.execute(input).getProductCategories();

        // Then
        assertThat(actualListOfProductCategories).isEqualTo(productCategories);
    }
}
