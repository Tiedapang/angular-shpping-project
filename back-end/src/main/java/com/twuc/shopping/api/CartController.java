package com.twuc.shopping.api;

import com.twuc.shopping.domain.Cart;
import com.twuc.shopping.domain.Product;
import com.twuc.shopping.po.CartPO;
import com.twuc.shopping.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Validated
@ResponseBody
public class CartController {
    @Autowired
    CartService cartService;
    @PostMapping("/cart")
    public boolean addCart(@RequestBody Cart cart){
        return cartService.operaCart(CartPO.builder().product(cart.getProduct()).count(cart.getCount()).createDate(cart.getCreateDate()).build());

    }
    @GetMapping("/cart")
    public List<Cart> getAllCartDatas(){
        return cartService.findAllCartDatas().stream().map(
                item ->
                        Cart.builder().product(item.getProduct())
                                .count(item.getCount())
                                .build()
        ).collect(Collectors.toList());
    }
    @GetMapping("/cart/{name}")
    public void deleteOrder(@PathVariable String name) throws UnsupportedEncodingException {
        cartService.deletCart(new String(name.getBytes("UTF-8"), "GBK"));

    }
    @GetMapping("/cart/deleteAll")
    public void deleteAllCart() {
        cartService.deleteAllCart();

    }
}
