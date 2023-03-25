package com.codementoring.ecommerceserver.core.usecases.productcategory;

import com.codementoring.ecommerceserver.core.domain.ProductCategory;
import com.codementoring.ecommerceserver.core.usecases.UseCase;
import lombok.Value;

import java.util.List;

public class SearchProductCategoryByNameUseCase extends UseCase<SearchProductCategoryByNameUseCase.InputValues, SearchProductCategoryByNameUseCase.OutputValues> {

    private final ProductCategoryRepository productCategoryRepository;

    public SearchProductCategoryByNameUseCase(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public OutputValues execute(InputValues inputValues) {
        return new OutputValues(productCategoryRepository.searchProductCategoryByName(inputValues.getSearchText()));
    }

    @Value
    public static class InputValues implements UseCase.InputValues {
        String searchText;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        List<ProductCategory> productCategories;
    }
}