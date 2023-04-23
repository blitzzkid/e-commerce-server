package com.ecommerceserver.presenter.restapi.productcategory;

import com.ecommerceserver.core.domain.ProductCategory;
import com.ecommerceserver.core.entities.TestCoreEntityGenerator;
import com.ecommerceserver.core.usecases.productcategory.GetAllProductCategoriesUseCase;
import com.ecommerceserver.core.usecases.productcategory.SearchProductCategoryByNameUseCase;
import com.ecommerceserver.presenter.restapi.common.BaseControllerTest;
import com.ecommerceserver.presenter.usecases.UseCaseExecutorImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductCategoryController.class)
public class ProductCategoryControllerTest extends BaseControllerTest {

    @SpyBean
    private UseCaseExecutorImpl useCaseExecutor;

    @MockBean
    private GetAllProductCategoriesUseCase getAllProductCategoriesUseCase;

    @MockBean
    private SearchProductCategoryByNameUseCase searchProductCategoryByNameUseCase;

    @Autowired
    private MockMvc mockMvc;

    @Override
    protected MockMvc getMockMvc() {
        return mockMvc;
    }

    @Configuration
    @ComponentScan(basePackages = {"com.ecommerceserver.presenter.restapi.productcategory", "com.ecommerceserver.presenter.restapi.common"})
    static class Config {
    }

    @Test
    public void getAllProductCategoriesReturnsOk() throws Exception {
        // Given
        List<ProductCategory> productCategories = TestCoreEntityGenerator.randomProductCategories();
        ProductCategory firstProductCategory = productCategories.get(0);

        GetAllProductCategoriesUseCase.InputValues inputValues = new GetAllProductCategoriesUseCase.InputValues();
        GetAllProductCategoriesUseCase.OutputValues outputValues = new GetAllProductCategoriesUseCase.OutputValues(productCategories);

        doReturn(outputValues)
                .when(getAllProductCategoriesUseCase)
                .execute(inputValues);

        // When
        final RequestBuilder payload = asyncGetRequest("/ProductCategory");

        // Then
        mockMvc.perform(payload)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(productCategories.size())))
                .andExpect(jsonPath("$[0].id", is(firstProductCategory.getId().getNumber().intValue())))
                .andExpect(jsonPath("$[0].name", is(firstProductCategory.getName())));
    }

    @Test
    public void getAllMatchingProductCategoriesByNameReturnsOk() throws Exception {
        // Given
        List<ProductCategory> productCategories = TestCoreEntityGenerator.randomProductCategories();
        ProductCategory firstProductCategory = productCategories.get(0);

        SearchProductCategoryByNameUseCase.InputValues inputValues = new SearchProductCategoryByNameUseCase.InputValues("abc");
        SearchProductCategoryByNameUseCase.OutputValues outputValues = new SearchProductCategoryByNameUseCase.OutputValues(productCategories);

        doReturn(outputValues)
                .when(searchProductCategoryByNameUseCase)
                .execute(inputValues);

        // When
        final RequestBuilder payload = asyncGetRequest("/ProductCategory/search/abc");

        // Then
        mockMvc.perform(payload)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(productCategories.size())))
                .andExpect(jsonPath("$[0].id", is(firstProductCategory.getId().getNumber().intValue())))
                .andExpect(jsonPath("$[0].name", is(firstProductCategory.getName())));
    }
}
