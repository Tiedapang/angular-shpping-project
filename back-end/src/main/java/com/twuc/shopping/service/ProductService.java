package com.twuc.shopping.service;



import com.twuc.shopping.api.ProductController;
import com.twuc.shopping.domain.Product;
import com.twuc.shopping.po.ProductPO;
import com.twuc.shopping.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
  final ProductRepository productRepository;


  public ProductService(ProductRepository productRepository1) {
    this.productRepository = productRepository1;

  }
    public List<ProductPO> findAll() {
        return productRepository.findAll();
    }

    public void deleteById(int deleteID) {
        productRepository.deleteById(deleteID);
    }

    public boolean addProduct(ProductPO productPO) {
      Optional<ProductPO> productPo = productRepository.findByName(productPO.getName());
      if (productPo.isPresent()) {
        return false;
      }else{
        productRepository.save(productPO);
        return true;
      }

    }

    public ProductPO getProductById(int product_id) {
    return productRepository.findById(product_id).get();
    }

    public boolean checkProductName(String productName) {
    Optional<ProductPO> productPO = productRepository.findByName(productName);
    if(productPO.equals(Optional.empty())){
      return false;
    }
    return true;
    }
}
