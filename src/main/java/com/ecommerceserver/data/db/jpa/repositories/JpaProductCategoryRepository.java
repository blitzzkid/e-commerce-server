package com.ecommerceserver.data.db.jpa.repositories;

import com.ecommerceserver.data.db.jpa.entities.ProductCategoryData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaProductCategoryRepository extends JpaRepository<ProductCategoryData, Long> {

    List<ProductCategoryData> findByNameContainingIgnoreCase(String searchText);
}
