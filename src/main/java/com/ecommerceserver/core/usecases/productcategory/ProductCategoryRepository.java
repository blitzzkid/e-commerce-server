package com.ecommerceserver.core.usecases.productcategory;

import com.ecommerceserver.core.domain.ProductCategory;

import java.util.List;

public interface ProductCategoryRepository {

    List<ProductCategory> getAllProductCategories();

    List<ProductCategory> searchProductCategoryByName(String productCategoryName);
}
