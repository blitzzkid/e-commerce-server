package com.codementoring.ecommerceserver.core.usecases.productcategory;

import com.codementoring.ecommerceserver.core.domain.ProductCategory;
import com.codementoring.ecommerceserver.core.usecases.UseCase;
import lombok.Value;

import java.util.List;

public class GetAllProductCategoriesUseCase extends UseCase<GetAllProductCategoriesUseCase.InputValues, GetAllProductCategoriesUseCase.OutputValues> {
    private final ProductCategoryRepository productCategoryRepository;

    public GetAllProductCategoriesUseCase(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public OutputValues execute(InputValues input) {
        return new OutputValues(productCategoryRepository.getAllProductCategories());
    }

    @Value
    public static class InputValues implements UseCase.InputValues {
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        List<ProductCategory> productCategories;
    }
}
