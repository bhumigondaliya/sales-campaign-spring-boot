package com.example.SaleCampaginSystemManagment.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Campagin")
public class Campagin {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "campaign_id")
    private int cid;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private  LocalDate endDate;
    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "campaignList",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Discount> campaignDiscount;
//    {"
//        " startDate": "12/09/2023", "endDate": "17/09/2023", "title":
//        "Diwali Discount", "campaignDiscount": [
//        {
//            "productId": "1", "discount": "10"
//        },
//        {
//            "productId": "2", "discount": "20"
//        }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Discount> getCampaignDiscount() {
        return campaignDiscount;
    }

    public void setCampaignDiscount(List<Discount> campaignDiscount) {
        this.campaignDiscount = campaignDiscount;
    }
}
