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
public class SearchProductCategoryByNameUseCaseTest {

    @Mock
    private ProductCategoryRepository productCategoryRepository;

    @InjectMocks
    private SearchProductCategoryByNameUseCase searchProductCategoryByNameUseCase;

    @Test
    public void searchProductCategoryByNameTest() {
        // Given
        List<ProductCategory> productCategories = TestCoreEntityGenerator.randomProductCategories();
        String searchText = "abc";
        SearchProductCategoryByNameUseCase.InputValues input = new SearchProductCategoryByNameUseCase.InputValues(searchText);

        doReturn(productCategories)
                .when(productCategoryRepository)
                .searchProductCategoryByName(searchText);

        // When
        final List<ProductCategory> actualListOfProductCategories = searchProductCategoryByNameUseCase.execute(input).getProductCategories();

        // Then
        assertThat(actualListOfProductCategories).isEqualTo(productCategories);
    }
}
