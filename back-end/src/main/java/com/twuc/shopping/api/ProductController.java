package com.twuc.shopping.api;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.twuc.shopping.responsePo.ProductResponse;
import com.twuc.shopping.po.ProductPO;
import com.twuc.shopping.repository.ProductRepository;
import com.twuc.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.twuc.shopping.domain.Product;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@Validated
@ResponseBody
public class ProductController {
  @Autowired
  ProductRepository productRepository;
  @Autowired
  ProductService productService;
  @GetMapping("/product")
  public ProductResponse getProductListByPageAble(@PathParam("pageSize") String pageSize, @PathParam("pageNumber") String pageNumber){
    Pageable pageable = PageRequest.of(Integer.parseInt(pageNumber)-1,Integer.parseInt(pageSize));
    ProductResponse productResponse = productService.findAll(pageable);
    return productResponse;
  }

  @DeleteMapping("/product/{id}")
  public ResponseEntity deleteProduct(@PathVariable String  id) throws JsonProcessingException {
    productService.deleteById(Integer.parseInt(id));
    return ResponseEntity.ok().build();
  }
  @PostMapping("/product")
  public ResponseEntity addProduct(@RequestBody @Valid Product  product) throws JsonProcessingException {
    ProductPO productPoNew = new ProductPO();
    productPoNew.setName(product.getName());
    productPoNew.setPrice(product.getPrice());
    productPoNew.setUnit(product.getUnit());
    productPoNew.setImgPath(product.getImgPath());
    productService.addProduct(productPoNew);
    return ResponseEntity.created(null).build();

  }
}
