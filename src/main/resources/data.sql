-- Inserting Categories
INSERT INTO category (name) VALUES ('Electronics');
INSERT INTO category (name) VALUES ('Books');
INSERT INTO category (name) VALUES ('Home Appliances');

-- Inserting Products
INSERT INTO product (name, price, rating, category_id) VALUES ('Laptop', 999.99, 5, 1);
INSERT INTO product (name, price, rating, category_id) VALUES ('E-Reader', 129.99, 4, 2);
INSERT INTO product (name, price, rating, category_id) VALUES ('Microwave', 89.99, 4, 3);
INSERT INTO product (name, price, rating, category_id) VALUES ('Coffee Maker', 39.99, 3, 3);
INSERT INTO product (name, price, rating, category_id) VALUES ('Smartphone', 699.99, 5, 1);
INSERT INTO product (name, price, rating, category_id) VALUES ('Tablet', 299.99, 4, 1);

-- Inserting Users
INSERT INTO user (email, password, first_name, last_name) VALUES ('john.doe@example.com', 'password123', 'John', 'Doe');
INSERT INTO user (email, password, first_name, last_name) VALUES ('jane.doe@example.com', 'password123', 'Jane', 'Doe');

-- Inserting Addresses
INSERT INTO address (street, zip, city, id) VALUES ('123 Main St', '12345', 'Anytown', 1);
INSERT INTO address (street, zip, city, id) VALUES ('456 Elm St', '54321', 'Anycity', 2);

-- Inserting Reviews
INSERT INTO review (comment, user_id, product_id) VALUES ('Great laptop!', 1, 1);
INSERT INTO review (comment, user_id, product_id) VALUES ('Love my E-Reader for daily reading.', 2, 2);
INSERT INTO review (comment, user_id, product_id) VALUES ('Works great for my small kitchen.', 1, 3);
INSERT INTO review (comment, user_id, product_id) VALUES ('Makes a great cup of coffee.', 2, 4);
INSERT INTO review (comment, user_id, product_id) VALUES ('Best phone I ever had.', 1, 5);
INSERT INTO review (comment, user_id, product_id) VALUES ('Great tablet for reading and browsing.', 2, 6);
INSERT INTO review (comment, user_id, product_id) VALUES ('Fast delivery and great customer service.', 1, 1);
INSERT INTO review (comment, user_id, product_id) VALUES ('Easy to use and great battery life.', 2, 5);
INSERT INTO review (comment, user_id, product_id) VALUES ('Great for watching movies and reading.', 1, 6);