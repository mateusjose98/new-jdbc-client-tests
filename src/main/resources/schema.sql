CREATE TABLE IF NOT EXISTS public.products (
    id SERIAL PRIMARY KEY,
    name_product VARCHAR(255) NOT NULL,
    price NUMERIC(10, 2) NOT NULL
);

CREATE TABLE IF NOT EXISTS public.orders (
    id SERIAL PRIMARY KEY,
    issuance_date timestamp NOT NULL,
    paymentMethod VARCHAR(50) NOT NULL
);


CREATE TABLE IF NOT EXISTS public.items (
    id SERIAL PRIMARY KEY,
    quantity INT NOT NULL,
    unit_current_amount NUMERIC(10, 2) NOT NULL,
    product_id INT not null,
    order_id INT  not null,
    constraint fk_product foreign key(product_id) references products(id),
    constraint fk_order foreign key(order_id) references orders(id)
);

