package com.ecommerceserver.core.usecases.productcategory;

import com.ecommerceserver.core.domain.ProductCategory;
import com.ecommerceserver.core.entities.TestCoreEntityGenerator;
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

    @Mock
    private ProductCategoryRepository productCategoryRepository;
    @InjectMocks
    private GetAllProductCategoriesUseCase getAllProductCategoriesUseCase;

    @Test
    public void getAllProductCategoriesTest() {
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
