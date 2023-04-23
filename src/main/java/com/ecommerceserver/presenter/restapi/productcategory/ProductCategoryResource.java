package com.ecommerceserver.presenter.restapi.productcategory;

import com.ecommerceserver.presenter.restapi.entities.ProductCategoryResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/ProductCategory")
public interface ProductCategoryResource {

    @GetMapping
    CompletableFuture<List<ProductCategoryResponse>> getAllProductCategories();

    @GetMapping("/search/{searchText}")
    CompletableFuture<List<ProductCategoryResponse>> getAllMatchingProductCategoriesByName(@PathVariable String searchText);
}
