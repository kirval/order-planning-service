CREATE SEQUENCE customer_id_seq START 1000000;
CREATE TABLE customer
(
    id        BIGINT PRIMARY KEY DEFAULT nextval('customer_id_seq'),
    name      TEXT UNIQUE NOT NULL,
    latitude  DECIMAL     NOT NULL,
    longitude DECIMAL     NOT NULL
);

CREATE SEQUENCE order_id_seq START 1000000;
CREATE TABLE "order"
(
    id          BIGINT PRIMARY KEY DEFAULT nextval('order_id_seq'),
    customer_id BIGINT UNIQUE NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer (id)
);