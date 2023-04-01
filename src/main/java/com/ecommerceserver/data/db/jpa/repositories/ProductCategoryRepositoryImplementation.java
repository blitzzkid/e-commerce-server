package com.ecommerceserver.data.db.jpa.repositories;

import com.ecommerceserver.core.domain.ProductCategory;
import com.ecommerceserver.core.usecases.productcategory.ProductCategoryRepository;
import com.ecommerceserver.data.db.jpa.entities.ProductCategoryData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductCategoryRepositoryImplementation implements ProductCategoryRepository {

    private JpaProductCategoryRepository jpaProductCategoryRepository;

    public ProductCategoryRepositoryImplementation(JpaProductCategoryRepository jpaProductCategoryRepository) {
        this.jpaProductCategoryRepository = jpaProductCategoryRepository;
    }

    @Override
    public List<ProductCategory> getAllProductCategories() {
        return jpaProductCategoryRepository
                .findAll()
                .parallelStream()
                .map(ProductCategoryData::fromThis)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductCategory> searchProductCategoryByName(String searchText) {
        return jpaProductCategoryRepository
                .findByNameContainingIgnoreCase(searchText)
                .parallelStream()
                .map(ProductCategoryData::fromThis)
                .collect(Collectors.toList());
    }
}
