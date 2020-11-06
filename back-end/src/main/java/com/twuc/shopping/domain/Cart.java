package com.twuc.shopping.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.twuc.shopping.po.ProductPO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Cart {
    private int count;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    private ProductPO product;
}
