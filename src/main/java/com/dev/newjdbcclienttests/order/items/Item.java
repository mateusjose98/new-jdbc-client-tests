package com.dev.newjdbcclienttests.order.items;

import com.dev.newjdbcclienttests.order.Order;
import com.dev.newjdbcclienttests.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    private Integer id;
    private Integer quantity;
    private BigDecimal unitCurrentAmount;
    private Product product;
    @JsonIgnore
    private Order order;
}
