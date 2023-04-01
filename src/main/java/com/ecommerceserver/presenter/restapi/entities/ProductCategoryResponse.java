package com.ecommerceserver.presenter.restapi.entities;

import com.ecommerceserver.core.domain.ProductCategory;
import lombok.Value;

import java.util.List;
import java.util.stream.Collectors;

@Value
public class ProductCategoryResponse {

    Long id;

    String name;

    public static ProductCategoryResponse from(ProductCategory productCategory) {
        return new ProductCategoryResponse(productCategory.getId().getNumber(), productCategory.getName());
    }

    public static List<ProductCategoryResponse> from(List<ProductCategory> productCategories) {
        return productCategories
                .stream()
                .map(ProductCategoryResponse::from)
                .collect(Collectors.toList());
    }
}
