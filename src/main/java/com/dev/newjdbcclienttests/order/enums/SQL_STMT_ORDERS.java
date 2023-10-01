package com.dev.newjdbcclienttests.order.enums;

public enum SQL_STMT_ORDERS {

    INSERT("INSERT INTO products (name_product, price) VALUES (:name, :price) returning id"),
    UPDATE("UPDATE products SET name_product = ?, price = ? WHERE id = ?"),
    DELETE("DELETE FROM products WHERE id = ?"),
    SELECT_BY_ID("""
            select
            	o.id as orderId,
            	o.issuance_date as issDate,
            	o.paymentmethod as paymentMethod,
            	i.id as itemId,
            	i.quantity,
            	i.unit_current_amount as unitCurrentAmount,
            	i.product_id as productId,
            	p.name_product as productName,
            	p.price
            from
            	orders o
            left join items i on
            	i.order_id = o.id
            left join products p on
            	p.id = i.product_id
            where
            	o.id = ?
            """),
    SELECT_ALL("SELECT id, name_product, price FROM products");

    private String query;

    public String getQuery() {
        return query;
    }

    SQL_STMT_ORDERS(String query) {
        this.query = query;
    }
}
