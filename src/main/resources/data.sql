-- Inserting users
INSERT INTO users (id, email, password_hash, first_name, last_name)
VALUES (1, 'user1@miu.edu', 'password1', 'John', 'Doe'),
       (2, 'user2@miu.edu', 'password2', 'Jane', 'Smith'),
       (3, 'user3@miu.edu', 'password3', 'Alice', 'Johnson'),
       (4, 'user4@miu.edu', 'password4', 'Bob', 'Williams'),
       (5, 'user5@miu.edu', 'password5', 'Charlie', 'Brown');

-- Inserting addresses for users
INSERT INTO addresses (id, street, zip, city, user_id)
VALUES (1, '123 Main St', '12345', 'Springfield', 1),
       (2, '456 Elm St', '67890', 'Shelbyville', 2),
       (3, '789 Oak St', '54321', 'Ogdenville', 3),
       (4, '101 Maple St', '09876', 'North Haverbrook', 4),
       (5, '202 Pine St', '11223', 'Capital City', 5);

-- Inserting categories
INSERT INTO product_categories (id, name)
VALUES (1, 'Electronics'),
       (2, 'Books'),
       (3, 'Home & Kitchen');

-- Inserting Apple products into the Electronics category
INSERT INTO products (id, name, price, rating, category_id)
VALUES (1, 'iPhone 13', 999.99, 4.8, 1),
       (2, 'MacBook Pro', 1999.99, 4.9, 1),
       (3, 'iPad Pro', 799.99, 4.7, 1),
       (4, 'Apple Watch', 399.99, 4.6, 1),
       (5, 'AirPods Pro', 249.99, 4.5, 1);

-- Inserting reviews for each product
INSERT INTO reviews (id, comment, user_id, product_id)
VALUES (1, 'Amazing phone with great features!', 1, 1),
       (2, 'Best laptop I have ever used!', 2, 2),
       (3, 'Very versatile and powerful tablet.', 3, 3),
       (4, 'A must-have for fitness enthusiasts.', 4, 4),
       (5, 'Great sound quality and noise cancellation.', 5, 5),
       (6, 'Loving the new camera on iPhone 13!', 2, 1),
       (7, 'The battery life is incredible.', 3, 2),
       (8, 'Perfect for both work and entertainment.', 4, 3),
       (9, 'Keeps track of all my activities.', 5, 4),
       (10, 'So comfortable to wear.', 1, 5),
       (11, 'iPhone 13 has a stunning display!', 3, 1),
       (12, 'Very powerful for video editing.', 4, 2),
       (13, 'Love the large screen on the iPad Pro.', 5, 3),
       (14, 'The ECG feature is very useful.', 1, 4),
       (15, 'Seamless integration with other Apple products.', 2, 5);
