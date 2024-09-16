package com.example.SaleCampaginSystemManagment.model;

import jakarta.persistence.*;

@Entity
@Table(name = "discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "discount_id")
    private int did;
    @Column(name = "discount")
    private double discount;    //campaign discount
    @Column(name = "product_id")
    private int productId;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="campaignDiscount")
    private Campagin campaignList;

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Campagin getCampaignList() {
        return campaignList;
    }

    public void setCampaignList(Campagin campaignList) {
        this.campaignList = campaignList;
    }
}
