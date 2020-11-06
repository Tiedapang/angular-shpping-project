package com.twuc.shopping.repository;

import com.twuc.shopping.po.CartPO;
import com.twuc.shopping.po.ProductPO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartRepository extends CrudRepository<CartPO, Integer> {
    List<CartPO> findAll();

    CartPO findByProductId(int productId);
}
