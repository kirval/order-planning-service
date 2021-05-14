INSERT INTO customers(id, name, coordinateX, coordinateY)
VALUES (1, 'Customer 1', 1, 1);

INSERT INTO warehouses(id, name, coordinateX, coordinateY)
VALUES (1, 'WH 1', 1, 1);

INSERT INTO products(id, name)
VALUES (1, 'Product 1');

INSERT INTO warehouse_product(warehouse_id, product_id)
VALUES (1, 1);