
INSERT INTO category (id, name) VALUES (1, 'Electronics');
INSERT INTO category (id, name) VALUES (2, 'Books');
INSERT INTO category (id, name) VALUES (3, 'Clothing');

INSERT INTO product (category_id, id, price, rating, name) VALUES (1, 1, 299.99, 4.5, 'Smartphone');
INSERT INTO product (category_id, id, price, rating, name) VALUES (2, 2, 19.99, 4.0, 'Science Fiction Novel');
INSERT INTO product (category_id, id, price, rating, name) VALUES (3, 3, 49.99, 3.5, 'Jeans');

INSERT INTO address (id, city, street, zip) VALUES (1, 'New York', '123 Main St', '10001');
INSERT INTO address (id, city, street, zip) VALUES (2, 'Los Angeles', '456 Elm St', '90001');
INSERT INTO address (id, city, street, zip) VALUES (3, 'Chicago', '789 Oak St', '60601');

INSERT INTO user (address_id, id, email, first_name, last_name, password) VALUES (1, 1, 'user1@example.com', 'John', 'Doe', 'password123');
INSERT INTO user (address_id, id, email, first_name, last_name, password) VALUES (2, 2, 'user2@example.com', 'Jane', 'Smith', 'password456');
INSERT INTO user (address_id, id, email, first_name, last_name, password) VALUES (3, 3, 'user3@example.com', 'Alice', 'Johnson', 'password789');

INSERT INTO review (id, product_id, user_id, comment) VALUES (1, 1, 1, 'Great phone!');
INSERT INTO review (id, product_id, user_id, comment) VALUES (2, 2, 2, 'Interesting book.');
INSERT INTO review (id, product_id, user_id, comment) VALUES (3, 3, 3, 'Comfortable jeans.');



