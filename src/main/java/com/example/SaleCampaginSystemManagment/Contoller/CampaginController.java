package com.example.SaleCampaginSystemManagment.Contoller;

import com.example.SaleCampaginSystemManagment.Schedular.CampaignScheduler;
import com.example.SaleCampaginSystemManagment.Service.CampaginService;
import com.example.SaleCampaginSystemManagment.model.Campagin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("campagin")
public class CampaginController {
    @Autowired
    CampaginService campaignService;
    @Autowired
    CampaignScheduler campaignScheduler;

//    {
//        "startDate": "12/09/2023", "endDate": "17/09/2023", "title":
//        "Diwali Discount", "campaignDiscount": [
//        {
//            "pId": "1", "discount": "10"
//        },
//          "pId": "1", "discount": "20"
//        {
//        }
//    }

    @PostMapping("create")
    //http://localhost:8080/Campagin/create
    public String create(@RequestBody Campagin campaign) {
        return campaignService.createCampaign(campaign);
    }

    @GetMapping("getAll")
    //http://localhost:8081/campaign/getAll
    public List<Campagin> getall(@RequestBody List<Campagin> campaigns) {
        return campaignService.getAll(campaigns);
    }


}
