package com.twuc.shopping.po;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class ProductPO {
  @Id
  @GeneratedValue
  private int id;
  private String name;
  private double price;
  private String unit;
  private String imgPath;
}
