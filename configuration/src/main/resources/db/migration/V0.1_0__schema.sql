CREATE SEQUENCE customer_id_seq;
CREATE TABLE customers
(
    id          INT         NOT NULL,
    name        VARCHAR(50) NOT NULL,
    coordinateX INT         NOT NULL,
    coordinateY INT         NOT NULL
);

CREATE SEQUENCE warehouse_id_seq;
CREATE TABLE warehouses
(
    id          INT         NOT NULL,
    name        VARCHAR(50) NOT NULL,
    coordinateX INT         NOT NULL,
    coordinateY INT         NOT NULL
);

CREATE SEQUENCE product_id_seq;
CREATE TABLE products
(
    id   INT                NOT NULL,
    name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE warehouse_product
(
    warehouse_id INT NOT NULL,
    product_id   INT NOT NULL,
    FOREIGN KEY (warehouse_id) REFERENCES warehouses (id),
    FOREIGN KEY (product_id) REFERENCES products (id),
    UNIQUE (warehouse_id, product_id)
);

CREATE SEQUENCE order_id_seq;
CREATE TABLE orders
(
    id           INT        NOT NULL,
    customer_id  INT UNIQUE NOT NULL,
    product_id   INT        NOT NULL,
    warehouse_id INT,
    FOREIGN KEY (customer_id) REFERENCES customers (id),
    FOREIGN KEY (product_id) REFERENCES products (id),
    FOREIGN KEY (warehouse_id) REFERENCES warehouses (id)
);