package com.dev.newjdbcclienttests.order;

import com.dev.newjdbcclienttests.order.enums.PaymentMethod;
import com.dev.newjdbcclienttests.order.items.Item;
import com.dev.newjdbcclienttests.product.Product;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class OrderResultSetExtractor implements ResultSetExtractor<Order> {

    @Override
    public Order extractData(ResultSet rs) throws SQLException, DataAccessException {
        Order result = null;

        while (rs.next()) {
            Integer orderId = rs.getInt("orderId");
            if (result == null) {
                result = new Order();
                result.setId(orderId);
                result.setIssuanceDate(rs.getObject("issDate", LocalDateTime.class));
                result.setPaymentMethod(PaymentMethod.valueOf(rs.getString("paymentMethod")));
            }
            result.addItem(
                    Item.builder()
                            .id(rs.getInt("itemId"))
                            .quantity(rs.getInt("quantity"))
                            .unitCurrentAmount(rs.getBigDecimal("unitCurrentAmount"))
                            .product(
                                    Product.builder()
                                            .id(rs.getInt("productId"))
                                            .nameProduct(rs.getString("productName"))
                                            .price(rs.getBigDecimal("price"))
                                            .build()
                            )
                            .build());
        }

        return result;
    }
}
