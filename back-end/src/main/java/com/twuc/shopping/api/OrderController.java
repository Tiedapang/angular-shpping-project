package com.twuc.shopping.api;

import com.twuc.shopping.domain.Order;
import com.twuc.shopping.domain.Product;
import com.twuc.shopping.service.OrderService;
import com.twuc.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Validated
@ResponseBody
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;
    @GetMapping("/order/list")
    public List<Order> getOrderList() {
        List<Order> Orders = orderService.findAll().stream().map(
                item ->
                        Order.builder().productName(productService.getProductById(item.getProductId()).getName())
                                .count(item.getCount())
                                .price(productService.getProductById(item.getProductId()).getPrice())
                                .unit(productService.getProductById(item.getProductId()).getUnit())
                                .build()
        ).collect(Collectors.toList());
        return Orders;
    }
}
