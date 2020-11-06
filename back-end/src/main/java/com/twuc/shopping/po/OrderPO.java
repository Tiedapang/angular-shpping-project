package com.twuc.shopping.po;

import com.twuc.shopping.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orderPo")
public class OrderPO {
    @Id
    @GeneratedValue
    private int id;
    private int count;
    private int productId;

}
