package com.dev.newjdbcclienttests.product;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    final JdbcClient jdbcClient;

    @Override
    @Transactional
    public Integer save(Product product) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcClient.sql(SQL_STMT_PRODUCTS.INSERT.getQuery())
                .param("price", product.getPrice())
                .param("name", product.getNameProduct())
                .update(keyHolder);
        return keyHolder.getKeyAs(Integer.class);
    }

    @Override
    public List<Product> read() {
        return jdbcClient.sql(SQL_STMT_PRODUCTS.SELECT_ALL.getQuery())
                .query(Product.class)
                .list();
    }

    @Override
    public Optional<Product> readById(Integer id) {
        return jdbcClient.sql(SQL_STMT_PRODUCTS.SELECT_BY_ID.getQuery())
                .param(id)
                .query(Product.class)
                .optional();
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        int deleted = jdbcClient.sql(SQL_STMT_PRODUCTS.DELETE.getQuery())
                .param(id)
                .update();
        if (deleted == 0) {
            throw new IllegalArgumentException("Não foi possível apagar registro id=" + id);
        }
    }

    @Override
    @Transactional
    public Integer update(Integer id, Product productNewValues) {
        int updated = jdbcClient.sql(SQL_STMT_PRODUCTS.UPDATE.getQuery())
                .param(1, productNewValues.getNameProduct())
                .param(2, productNewValues.getPrice())
                .param(3, id)
                .update();
        System.out.println(updated);
        return updated;
    }

}
