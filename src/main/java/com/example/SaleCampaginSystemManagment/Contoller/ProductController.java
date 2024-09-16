package com.example.SaleCampaginSystemManagment.Contoller;

import com.example.SaleCampaginSystemManagment.Service.ProductService;
import com.example.SaleCampaginSystemManagment.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("save")
    //http://localhost:8080/Product/save
    public List<Product> save(@RequestBody List<Product> products)
    {
        return productService.save(products);
    }

    @GetMapping("getProduct")
    //http://localhost:8080/product/getProduct?page=1&pageSize=3
    public Page<Product> getProducts(@RequestParam(defaultValue = "5")int page, @RequestParam(defaultValue = "4")int pageSize)
    {
        Page<Product>products=  productService.getProducts(page,pageSize);
        return products;
    }


}

