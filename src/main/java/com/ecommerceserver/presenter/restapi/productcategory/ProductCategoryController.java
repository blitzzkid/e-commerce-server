package com.ecommerceserver.presenter.restapi.productcategory;

import com.ecommerceserver.core.usecases.UseCaseExecutor;
import com.ecommerceserver.core.usecases.productcategory.GetAllProductCategoriesUseCase;
import com.ecommerceserver.core.usecases.productcategory.SearchProductCategoryByNameUseCase;
import com.ecommerceserver.presenter.restapi.entities.ProductCategoryResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class ProductCategoryController implements ProductCategoryResource{

    private UseCaseExecutor useCaseExecutor;
    private GetAllProductCategoriesUseCase getAllProductCategoriesUseCase;
    private SearchProductCategoryByNameUseCase searchProductCategoryByNameUseCase;

    public ProductCategoryController(UseCaseExecutor useCaseExecutor,
                                     GetAllProductCategoriesUseCase getAllProductCategoriesUseCase,
                                     SearchProductCategoryByNameUseCase searchProductCategoryByNameUseCase) {
        this.useCaseExecutor = useCaseExecutor;
        this.getAllProductCategoriesUseCase = getAllProductCategoriesUseCase;
        this.searchProductCategoryByNameUseCase = searchProductCategoryByNameUseCase;
    }

    @Override
    public CompletableFuture<List<ProductCategoryResponse>> getAllProductCategories() {
        return useCaseExecutor.execute(
                getAllProductCategoriesUseCase,
                new GetAllProductCategoriesUseCase.InputValues(),
                (outputValues) -> ProductCategoryResponse.from(outputValues.getProductCategories()));
    }

    @Override
    public CompletableFuture<List<ProductCategoryResponse>> getAllMatchingProductCategoriesByName(@PathVariable String searchText) {
        return useCaseExecutor.execute(
                searchProductCategoryByNameUseCase,
                new SearchProductCategoryByNameUseCase.InputValues(searchText),
                (outputValues) -> ProductCategoryResponse.from(outputValues.getProductCategories()));
    }
}
