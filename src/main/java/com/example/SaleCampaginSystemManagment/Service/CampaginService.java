package com.example.SaleCampaginSystemManagment.Service;

import com.example.SaleCampaginSystemManagment.Repository.CampaginRepostiory;
import com.example.SaleCampaginSystemManagment.model.Campagin;
import com.example.SaleCampaginSystemManagment.model.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaginService {
    @Autowired
    CampaginRepostiory campaignRepository;

    @Autowired
    ProductService productService;

    public String createCampaign(Campagin campaign)
    {
       try {
           List<Discount> discounts = campaign.getCampaignDiscount();
           for (Discount discount : discounts) {
               discount.setCampaignList(campaign);
           }
           campaignRepository.save(campaign);
       } catch (Exception e) {
           return  e.getMessage();
       }
       return "Success";
    }
    public List<Campagin>getAll(List<Campagin> campaign)
    {
        return campaignRepository.findAll();
    }
    public void startCampaign(Campagin campaign)
    {
        productService.applyCampaignDiscount(campaign);
    }
    public void endCampaign(Campagin campaign)
    {
        productService.revertCampaignDiscount(campaign);
    }

}

