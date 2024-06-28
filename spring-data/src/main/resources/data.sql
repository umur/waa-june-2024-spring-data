INSERT INTO category (id, name) VALUES (1, 'Electronics');
INSERT INTO category (id, name) VALUES (2, 'Books');
INSERT INTO category (id, name) VALUES (3, 'Clothing');


INSERT INTO product (id, name, price, rating, category_id) VALUES (1, 'Laptop', 1200.00, 5, 1);
INSERT INTO product (id, name, price, rating, category_id) VALUES (2, 'Smartphone', 800.00, 4, 1);
INSERT INTO product (id, name, price, rating, category_id) VALUES (3, 'Novel', 20.00, 4, 2);
INSERT INTO product (id, name, price, rating, category_id) VALUES (4, 'T-Shirt', 15.00, 3, 3);
INSERT INTO product (id, name, price, rating, category_id) VALUES (5, 'Jeans', 40.00, 4, 3);


INSERT INTO review (id, comment) VALUES (1, 'Great laptop with excellent performance.');
INSERT INTO review (id, comment) VALUES (2, 'Good value for money.');
INSERT INTO review (id, comment) VALUES (3, 'Very interesting novel.');
INSERT INTO review (id, comment) VALUES (4, 'Comfortable and stylish.');
INSERT INTO review (id, comment) VALUES (5, 'High-quality fabric.');


INSERT INTO address (id, street, city, zip) VALUES (1, '123 Main St', 'Springfield', '62704');
INSERT INTO address (id, street, city, zip) VALUES (2, '456 Elm St', 'Metropolis', '10001');
INSERT INTO address (id, street, city, zip) VALUES (3, '789 Oak St', 'Gotham', '07001');


INSERT INTO user (id, email, first_Name, last_Name, password, address_id) VALUES (1, 'John', 'Doe', 'john.doe@example.com', 'password123', 1);
INSERT INTO user (id, email, first_Name, last_Name,  password, address_id) VALUES (2, 'Jane', 'Smith', 'jane.smith@example.com', 'password456', 2);
INSERT INTO user (id, email, first_Name, last_Name,  password, address_id) VALUES (3, 'Admin', 'User', 'admin@example.com', 'adminpass', 3);

UPDATE review SET user_id = 1 WHERE id = 1;
UPDATE review SET user_id = 1 WHERE id = 2;
UPDATE review SET user_id = 2 WHERE id = 3;
UPDATE review SET user_id = 3 WHERE id = 4;
UPDATE review SET user_id = 3 WHERE id = 5;