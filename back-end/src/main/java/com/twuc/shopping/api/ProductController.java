package com.twuc.shopping.api;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.twuc.shopping.po.ProductPO;
import com.twuc.shopping.repository.ProductRepository;
import com.twuc.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.twuc.shopping.domain.Product;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@Validated
@ResponseBody
public class ProductController {
  @Autowired
  ProductRepository productRepository;
  @Autowired
  ProductService productService;

  @GetMapping("/product/list")
  public List<Product> getProductList() {
    List<Product> products = productService.findAll().stream().map(
            item ->
                    Product.builder().name(item.getName())
                            .price(item.getPrice())
                            .unit(item.getUnit())
                            .imgPath(item.getImgPath())
                            .build()
    ).collect(Collectors.toList());
   return products;
  }

  @DeleteMapping("/product")
  public void deleteProduct(@RequestBody String  deleteID) throws JsonProcessingException {
    productService.deleteById(Integer.parseInt(deleteID));
  }
  @PostMapping("/product")
  public boolean addProduct(@RequestBody @Valid Product  product) throws JsonProcessingException {
    ProductPO productPoNew = new ProductPO();
    productPoNew.setName(product.getName());
    productPoNew.setPrice(product.getPrice());
    productPoNew.setUnit(product.getUnit());
    productPoNew.setImgPath(product.getImgPath());
    return productService.addProduct(productPoNew);

  }
  @GetMapping("/product/{name}")
  public boolean checkProductName(@PathVariable String name){
    return productService.checkProductName(name);
  }
  
}
