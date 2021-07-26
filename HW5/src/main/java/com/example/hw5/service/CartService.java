package com.example.hw5.service;

import com.example.hw5.entity.Cart;
import com.example.hw5.entity.Product;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
public class CartService {
    @GetMapping("/card/read")
    @ResponseBody
    public List<Cart> read() {
        List<Cart> cartList = new ArrayList<>();
        Cart cart1 = new Cart();
        cart1.setId(5);
        cart1.setSum(1000);
        cartList.add(cart1);
        return cartList;
    }

    @PostMapping("/card/create")
    @ResponseBody
    public boolean create(Cart cart1) {
        List<Cart> list = new ArrayList<>();
        list.add(cart1);
        if (list.contains(cart1)) {
            return true;
        } else {
            return false;
        }
    }

    @PostMapping("/card/update")
    @ResponseBody
    public boolean update(Cart neew) {
        List<Cart> cartList = new ArrayList<>();
        Cart old = new Cart();
        old.setId(7);
        old.setSum(5500);
        cartList.add(old);
        neew.setId(old.getId());
        cartList.remove(old);
        cartList.add(neew);
        if (cartList.contains(neew) && (!cartList.contains(old))) {
            return true;
        } else {
            return false;
        }
    }

    @DeleteMapping("/card/delete")
    @ResponseBody
    public boolean delete(Cart old) {
        List<Cart> cartList = new ArrayList<>();
        cartList.add(old);
        cartList.remove(old);
        if (!cartList.contains(old)) {
            return true;
        } else {
            return false;
        }
    }
    @GetMapping("/summaryOfCard")
    @ResponseBody
    public Integer summary() {
        Product product = new Product();
        product.setCountOfFruits(5);
        product.setCountOfVegetables(5);
        product.setCountOfMeat(5);
        int sum = product.getCountOfFruits() * 10 + product.getCountOfVegetables() * 15 + product.getCountOfMeat() * 40;
        return sum;
    }

}
