package com.alaeldin.ecommercebackend.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne()
    @JoinColumn(name = "category_id",referencedColumnName="id", insertable=false, updatable=false)
    private ProductCategory category;
    @Column(nullable = false)
    private long category_id;
    @Column(name = "sku")
    private String sku;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "unit_price")
    private int unitPrice;
    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "active")
    private boolean active;
    @Column(name = "units_in_stock")
  private int unitInStock = 0;
    @Column(name = "date_created")
  private Date dateCreated;
    @Column(name = "last_updated")
  private Date lastUpdated;
}
