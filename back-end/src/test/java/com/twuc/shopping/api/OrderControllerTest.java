package com.twuc.shopping.api;

import com.twuc.shopping.domain.Product;
import com.twuc.shopping.po.OrderPO;
import com.twuc.shopping.po.ProductPO;
import com.twuc.shopping.repository.OrderRepository;
import com.twuc.shopping.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderController orderController;
    @Autowired
    ProductRepository productRepository;
    @BeforeEach
    void setUp() {
        ProductPO productPO = ProductPO.builder()
                .name("可乐")
                .price(5)
                .unit("瓶")
                .build();
        ProductPO product2PO = ProductPO.builder()
                .name("可乐2")
                .price(5)
                .unit("瓶")
                .build();
        productRepository.save(productPO);
        productRepository.save(product2PO);
        OrderPO orderPO1 = OrderPO.builder().count(2).product(productPO).build();
        OrderPO orderPO2 = OrderPO.builder().count(3).product(product2PO).build();
        orderRepository.save(orderPO1);
        orderRepository.save(orderPO2);

    }
    @Test
    public void shouldGetAllOrders() throws Exception {
        mockMvc.perform(get("/order/list"))
                .andExpect(jsonPath("$", hasSize(2)));
    }

}