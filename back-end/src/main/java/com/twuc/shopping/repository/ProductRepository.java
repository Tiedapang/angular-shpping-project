package com.twuc.shopping.repository;

import com.twuc.shopping.po.ProductPO;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends PagingAndSortingRepository<ProductPO, Integer> {
  List<ProductPO> findAll();
  Page<ProductPO> findAll(Pageable pageable);
  Optional<ProductPO> findByName(String name);
}
