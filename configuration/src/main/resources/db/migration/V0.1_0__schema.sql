CREATE SEQUENCE customer_id_seq START 1000000;
CREATE TABLE customers
(
    id          BIGINT PRIMARY KEY DEFAULT nextval('customer_id_seq'),
    name        TEXT UNIQUE NOT NULL,
    coordinateX INT         NOT NULL,
    coordinateY INT         NOT NULL
);

CREATE SEQUENCE warehouse_id_seq START 1000000;
CREATE TABLE warehouses
(
    id          BIGINT PRIMARY KEY DEFAULT nextval('warehouse_id_seq'),
    name        TEXT UNIQUE NOT NULL,
    coordinateX INT         NOT NULL,
    coordinateY INT         NOT NULL
);

CREATE SEQUENCE product_id_seq START 1000000;
CREATE TABLE products
(
    id   BIGINT PRIMARY KEY DEFAULT nextval('product_id_seq'),
    name TEXT UNIQUE NOT NULL
);

CREATE TABLE warehouse_product
(
    warehouse_id BIGINT NOT NULL,
    product_id   BIGINT NOT NULL,
    FOREIGN KEY (warehouse_id) references warehouses (id),
    FOREIGN KEY (product_id) references products (id),
    UNIQUE (warehouse_id, product_id)
);

CREATE SEQUENCE order_id_seq START 1000000;
CREATE TABLE orders
(
    id           BIGINT PRIMARY KEY DEFAULT nextval('order_id_seq'),
    customer_id  BIGINT UNIQUE NOT NULL,
    product_id   BIGINT        NOT NULL,
    warehouse_id BIGINT,
    FOREIGN KEY (customer_id) REFERENCES customers (id),
    FOREIGN KEY (product_id) REFERENCES products (id),
    FOREIGN KEY (warehouse_id) REFERENCES warehouses (id)
);