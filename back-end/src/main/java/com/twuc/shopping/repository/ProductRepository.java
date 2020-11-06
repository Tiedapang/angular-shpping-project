package com.twuc.shopping.repository;

import com.twuc.shopping.po.ProductPO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<ProductPO, Integer> {
  List<ProductPO> findAll();
  Optional<ProductPO> findByName(String name);
}
