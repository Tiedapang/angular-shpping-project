package com.twuc.shopping.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.domain.Product;
import com.twuc.shopping.po.ProductPO;
import com.twuc.shopping.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpServletRequest;
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
@SpringBootTest
@AutoConfigureMockMvc
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
//        ProductPO productPo = ProductPO.builder()
//                .name("可乐")
//                .price(5)
//                .unit("瓶")
//                .build();
//        productRepository.save(productPo);
    }
    @Test
    public void shouldAddProduct() throws Exception {
        Product product = Product.builder()
                .name("可乐")
                .price(5.0)
                .unit("瓶")
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(product);
        mockMvc.perform(post("/product").content(jsonStr)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        List<ProductPO> productPOS= productRepository.findAll();
        assertNotNull(productPOS);
        assertEquals(productPOS.size(),1);
        assertEquals(productPOS.get(0).getName(),"可乐");

    }
//    @Test
//    public void shouldGetProducts() throws Exception {
//        HttpServletRequest httpServletRequest = null;
//        httpServletRequest.setAttribute("pageSize",0);
//        httpServletRequest.setAttribute("pageNumber",1);
//        mockMvc.perform(get("/product"))
//                .andExpect(jsonPath("$", hasSize(1)));
//    }

    @Test
    public void shouldDeleteProductById() throws Exception {
        ProductPO productPO = ProductPO.builder()
                .name("可乐")
                .price(5.0)
                .unit("瓶")
                .build();
        ProductPO productPO1 = productRepository.save(productPO);
        mockMvc.perform(delete("/product/{id}", productPO1.getId())).andExpect(status().isOk());
        assertEquals(productRepository.findAll().size(), 0);
    }
}
