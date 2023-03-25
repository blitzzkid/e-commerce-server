package com.codementoring.ecommerceserver.data.db.jpa.entities;

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

}