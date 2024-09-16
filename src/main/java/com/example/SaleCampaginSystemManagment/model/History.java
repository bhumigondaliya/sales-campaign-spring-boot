package com.example.SaleCampaginSystemManagment.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "History")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @JoinColumn(name = "product_id")
    private int pid;

    @Column(name = "date")
    private LocalDate startdate;

    @Column(name = "old_price")
    private Double oldPrice;
    @Column(name = "campaign_price")
    private Double campaignPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public LocalDate getStartdate() {
        return startdate;
    }

    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }

    public Double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Double getCampaignPrice() {
        return campaignPrice;
    }

    public void setCampaignPrice(Double campaignPrice) {
        this.campaignPrice = campaignPrice;
    }
}
