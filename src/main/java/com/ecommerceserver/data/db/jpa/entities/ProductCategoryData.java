package com.ecommerceserver.data.db.jpa.entities;

import com.ecommerceserver.core.domain.Identity;
import com.ecommerceserver.core.domain.ProductCategory;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "product_category")
@Getter
@Setter
@EqualsAndHashCode(of = {"name"})
@Table(name = "product_category")
@ToString(of = {"name"})
public class ProductCategoryData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    public static ProductCategoryData newInstance(String name) {
        return new ProductCategoryData(null, name);
    }

    public ProductCategory fromThis() {
        return new ProductCategory(
                new Identity(id),
                name
        );
    }
}
