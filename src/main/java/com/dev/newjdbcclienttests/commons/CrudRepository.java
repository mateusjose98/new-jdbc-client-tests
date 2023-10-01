package com.dev.newjdbcclienttests.commons;

import com.dev.newjdbcclienttests.product.Product;

import java.util.List;
import java.util.Optional;

public interface CrudRepository <ENTITY>{
    Integer save(ENTITY entity);

    List<ENTITY> read();

    Optional<ENTITY> readById(Integer id);

    void delete(Integer id);

    Integer update(Integer id, ENTITY entity);
}
