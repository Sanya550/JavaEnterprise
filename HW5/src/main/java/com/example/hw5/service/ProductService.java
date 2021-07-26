package com.example.hw5.service;


import com.example.hw5.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductService {
    @GetMapping("/product/read")
    @ResponseBody
    public List<Product> read() {
        List<Product> productList = new ArrayList<>();
        Product product = new Product();
        product.setId(5);
        product.setCountOfVegetables(5);
        product.setCountOfFruits(6);
        product.setCountOfMeat(4);
        productList.add(product);
        return productList;
    }

    @PostMapping("/product/create")
    @ResponseBody
    public boolean create(Product product) {
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        if (productList.contains(product)) {
            return true;
        } else {
            return false;
        }
    }

    @PostMapping("/product/update")
    @ResponseBody
    public boolean update(Product neew) {
        List<Product> productList = new ArrayList<>();
        Product old = new Product();
        old.setId(7);
        old.setCountOfMeat(2);
        old.setCountOfVegetables(3);
        old.setCountOfFruits(4);
        productList.add(old);
        productList.remove(old);
        productList.add(neew);
        if(productList.contains(neew)&&(!productList.contains(old))){
            return true;
        }else{
            return false;
        }
    }

    @DeleteMapping("/product/delete")
    @ResponseBody
    public boolean delete(Product product) {
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.remove(product);
        if (!productList.contains(product)) {
            return true;
        } else {
            return false;
        }
    }
}
