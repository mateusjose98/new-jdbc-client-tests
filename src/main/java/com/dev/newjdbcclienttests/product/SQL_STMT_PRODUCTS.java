package com.dev.newjdbcclienttests.product;

public enum SQL_STMT_PRODUCTS {

    INSERT ("INSERT INTO products (name_product, price) VALUES (:name, :price) returning id"),
    UPDATE("UPDATE products SET name_product = ?, price = ? WHERE id = ?"),
    DELETE("DELETE FROM products WHERE id = ?"),
    SELECT_BY_ID("SELECT id, name_product, price FROM products WHERE id = ?"),
    SELECT_ALL("SELECT id, name_product, price FROM products");

    private String query;

    public String getQuery() {
        return query;
    }
    SQL_STMT_PRODUCTS(String query) {
        this.query = query;
    }
}
