package com.twuc.shopping.service;



import com.twuc.shopping.domain.Product;
import com.twuc.shopping.exception.ProductNameAlreadyExistException;
import com.twuc.shopping.exception.ProductNotExistException;
import com.twuc.shopping.responsePo.ProductResponse;
import com.twuc.shopping.po.ProductPO;
import com.twuc.shopping.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
  final ProductRepository productRepository;


  public ProductService(ProductRepository productRepository1) {
    this.productRepository = productRepository1;

  }

    public void deleteById(int deleteID) {
    if(productRepository.findById(deleteID).isPresent()){
      productRepository.deleteById(deleteID);
    }else {
      throw new ProductNotExistException("抱歉，该商品信息不存在！");
    }

    }

    public void addProduct(ProductPO productPO) {
      Optional<ProductPO> productPo = productRepository.findByName(productPO.getName());
      if (productPo.isPresent()) {
        throw new ProductNameAlreadyExistException("该商品名已经存在！");
      }else{
        productRepository.save(productPO);
      }

    }

    public ProductPO getProductById(int product_id) {
    return productRepository.findById(product_id).get();
    }


  public ProductResponse findAll(Pageable pageable) {
    ProductResponse productResponse = new ProductResponse();
    Page<ProductPO> productPOS = productRepository.findAll(pageable);
    if(productPOS == null){
      return productResponse;
    }
    productResponse.setProductList(productPOS.stream().map(
            item ->
                    Product .builder().id(item.getId())
                            .name(item.getName())
                            .price(item.getPrice())
                            .unit(item.getUnit())
                            .imgPath(item.getImgPath())
                            .build()
    ).collect(Collectors.toList()));
    productResponse.setTotalCount(productRepository.count());
    return productResponse;
  }
}
