package com.example.SaleCampaginSystemManagment.Service;

import com.example.SaleCampaginSystemManagment.Repository.HistoryRepository;
import com.example.SaleCampaginSystemManagment.Repository.ProductRepository;
import com.example.SaleCampaginSystemManagment.model.Campagin;
import com.example.SaleCampaginSystemManagment.model.Discount;
import com.example.SaleCampaginSystemManagment.model.History;
import com.example.SaleCampaginSystemManagment.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private HistoryRepository historyRepository;

    public List<Product> save(List<Product> products)
    {

        return productRepository.saveAll(products);
    }

    public Page<Product> getProducts(int pageNumber, int pageSize)
    {
        Pageable pageable= PageRequest.of(pageNumber,pageSize);
        return productRepository.findAll(pageable);
    }

    public void applyCampaignDiscount(Campagin campaign)
    {
        List<Discount>discounts=campaign.getCampaignDiscount();
        for(int i=0;i<discounts.size();i++)
        {
            Discount discount= discounts.get(i);
            Product product = productRepository.findById(discount.getProductId()).get();
            History history = new History();

            history.setPid(product.getProductId());
            history.setOldPrice(product.getCurrentPrice());
            history.setCampaignPrice(product.getCurrentPrice()-(product.getCurrentPrice() * (discount.getDiscount() / 100.0)));
            history.setStartdate(LocalDate.now());
            historyRepository.save(history);

            product.setCurrentPrice(history.getCampaignPrice());
            productRepository.save(product);
        }
    }

    public void revertCampaignDiscount(Campagin campaign)
    {
        List<Discount>discounts=campaign.getCampaignDiscount();

        for(int i=0;i< discounts.size();i++)
        {
            Discount discount= discounts.get(i);
            Product product=productRepository.findById(discount.getProductId()).get();
            History history=new History();
            product.setCurrentPrice(history.getOldPrice());
            productRepository.save(product);
        }
    }

}

