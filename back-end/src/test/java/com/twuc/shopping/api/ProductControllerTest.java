package com.twuc.shopping.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.domain.Product;
import com.twuc.shopping.po.ProductPO;
import com.twuc.shopping.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;

class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductController productController;
    @BeforeEach
    void setUp() {
        productRepository.deleteAll();
    }
    @Test
    public void shouldAddProduct() throws Exception {
        Product product = Product.builder()
                .name("可乐")
                .price(5)
                .unit("瓶")
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(product);
        mockMvc.perform(post("/product/event").contentType(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", is(true)));

    }
    @Test
    public void shouldDeleteProduct() throws Exception {
        List<ProductPO> products = productRepository.findAll();
        if(products.size() > 0){
            mockMvc.perform(delete("/product/event")
                    .contentType(String.valueOf(products.get(0).getId()))
            ).andExpect(status().isOk());
        }
    }

    @Test
    public void shouldGetProducts() throws Exception {
        ProductPO productPo = ProductPO.builder()
                .name("可乐")
                .price(5)
                .unit("瓶")
                .build();
        mockMvc.perform(get("/product/list"))
                .andExpect(jsonPath("$", hasSize(1)));
    }
}