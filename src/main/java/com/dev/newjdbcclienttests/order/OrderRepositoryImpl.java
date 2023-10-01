package com.dev.newjdbcclienttests.order;

import com.dev.newjdbcclienttests.order.enums.SQL_STMT_ORDERS;
import com.dev.newjdbcclienttests.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    final JdbcClient jdbcClient;
    final ProductRepository productRepository;

    @Override
    public Integer save(Order order) {
        String insertSql = "INSERT INTO orders() values ()";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcClient.sql(insertSql)
                .param("issuanceDate", LocalDateTime.now())
                .param("paymentMethod", order.getPaymentMethod())
                .update(keyHolder);
        return keyHolder.getKeyAs(Integer.class);

    }

    @Override
    public List<Order> read() {
        return null;
    }

    @Override
    public Optional<Order> readById(Integer id) {
        Order result = jdbcClient.sql(SQL_STMT_ORDERS.SELECT_BY_ID.getQuery())
                .param(id)
                .query(new OrderResultSetExtractor());
        return Optional.of(result);

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Integer update(Integer id, Order order) {
        return null;
    }
}
