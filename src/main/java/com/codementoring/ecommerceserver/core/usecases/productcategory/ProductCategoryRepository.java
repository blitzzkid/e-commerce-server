package com.codementoring.ecommerceserver.core.usecases.productcategory;

import com.codementoring.ecommerceserver.core.domain.ProductCategory;

import java.util.List;

public interface ProductCategoryRepository {

    List<ProductCategory> getAllProductCategories();

}
