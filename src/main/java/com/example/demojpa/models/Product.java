package com.example.demojpa.models;

import com.example.demojpa.enums.ProductStatus;
import jakarta.persistence.*;

import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "Product.findAll", query = "select p from Product p where p.productStatus =: status"
        )
})
public class Product {
    @Column(length = 25)
    private String unit;
    @Column(name = "status", columnDefinition = "INT(11)")
    private ProductStatus productStatus;
    @Column(name = "manufacturer_name", length = 100)
    private String manufacturer;
    @Column(length = 150)
    private String name;
    @Column(length = 250)
    private String description;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;
    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImageList;
    @OneToMany(mappedBy = "product")
    private List<ProductPrice> productPrices;

    public Product() {
    }

    public Product(String unit, ProductStatus productStatus, String manufacturer, String name, String description, long id) {
        this.unit = unit;
        this.productStatus = productStatus;
        this.manufacturer = manufacturer;
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
