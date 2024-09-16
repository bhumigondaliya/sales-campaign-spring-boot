package com.example.SaleCampaginSystemManagment.Schedular;

import com.example.SaleCampaginSystemManagment.Repository.CampaginRepostiory;
import com.example.SaleCampaginSystemManagment.Service.CampaginService;
import com.example.SaleCampaginSystemManagment.model.Campagin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class CampaignScheduler {
    @Autowired
    private CampaginRepostiory campaignRepository;

    @Autowired
    private CampaginService campaignService;


    @Scheduled(initialDelay = 2000, fixedRate = 3000)
    public void updateCampaign()
    {
        System.out.println("Start this program");
        LocalDate today=LocalDate.now();
        List<Campagin> campaigns=campaignRepository.findAll();

        for(int i=0;i<campaigns.size();i++)
        {
           Campagin campaign=campaigns.get(i);
            if(campaign.getStartDate().isEqual(today))
            {
                campaignService.startCampaign(campaign);
            }
            else if(campaign.getEndDate().isEqual(today))
            {
                campaignService.endCampaign(campaign);
            }
        }
    }
}

