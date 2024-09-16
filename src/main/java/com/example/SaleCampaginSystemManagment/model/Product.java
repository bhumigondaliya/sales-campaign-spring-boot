package com.example.SaleCampaginSystemManagment.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "mrp")
    private Double mrp;
    @Column(name="current_price")
    private Double currentPrice;
    @Column(name = "discount")
    private Double discount;

    @Column(name = "inventory_count")
    private int inventoryCount;
    // "title": "TV",
    //        "description": "Description for product 1",
    //        "mrp": 100.0,
    //        "currentPrice": 80.0,
    //        "discount": 20.0,
    //        "inventoryCount": 50


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getMrp() {
        return mrp;
    }

    public void setMrp(Double mrp) {
        this.mrp = mrp;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public int getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(int inventoryCount) {
        this.inventoryCount = inventoryCount;
    }
}
