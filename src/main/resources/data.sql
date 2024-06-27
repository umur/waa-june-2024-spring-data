-- Populating user table
INSERT INTO user (id, email, first_name, last_name, password) VALUES
                                                                  (1, 'john.doe@example.com', 'John', 'Doe', 'password1'),
                                                                  (2, 'jane.doe@example.com', 'Jane', 'Doe', 'password2'),
                                                                  (3, 'alice.smith@example.com', 'Alice', 'Smith', 'password3'),
                                                                  (4, 'bob.jones@example.com', 'Bob', 'Jones', 'password4'),
                                                                  (5, 'charlie.brown@example.com', 'Charlie', 'Brown', 'password5');

-- Populating address table
INSERT INTO address (id, user_id, city, street, zip) VALUES
                                                         (1, 1, 'New York', '5th Avenue', '10001'),
                                                         (2, 2, 'Los Angeles', 'Sunset Boulevard', '90001'),
                                                         (3, 3, 'Chicago', 'Michigan Avenue', '60601'),
                                                         (4, 4, 'Houston', 'Main Street', '77001'),
                                                         (5, 5, 'Phoenix', 'Camelback Road', '85001');

-- Populating category table
INSERT INTO category (id, name) VALUES
                                    (1, 'Electronics'),
                                    (2, 'Books'),
                                    (3, 'Clothing'),
                                    (4, 'Home & Kitchen'),
                                    (5, 'Toys');

-- Populating product table
INSERT INTO product (id, name, price, rating, category_id) VALUES
                                                               (1, 'Smartphone', 699.99, 4.5, 1),
                                                               (2, 'Laptop', 999.99, 4.7, 1),
                                                               (3, 'Novel', 19.99, 4.3, 2),
                                                               (4, 'T-Shirt', 14.99, 4.0, 3),
                                                               (5, 'Blender', 49.99, 4.2, 4),
                                                               (6, 'Action Figure', 24.99, 4.8, 5),
                                                               (7, 'Headphones', 149.99, 4.6, 1),
                                                               (8, 'Cookbook', 29.99, 4.5, 2),
                                                               (9, 'Jeans', 39.99, 4.1, 3),
                                                               (10, 'Vacuum Cleaner', 199.99, 4.4, 4);

-- Populating review table
INSERT INTO review (id, product_id, user_id, comment) VALUES
                                                          (1, 1, 1, 'Great smartphone, very satisfied.'),
                                                          (2, 2, 2, 'Excellent laptop for the price.'),
                                                          (3, 3, 3, 'Interesting read, enjoyed it.'),
                                                          (4, 4, 4, 'Good quality T-shirt.'),
                                                          (5, 5, 5, 'Works well, very useful.'),
                                                          (6, 6, 1, 'My kids love this action figure.'),
                                                          (7, 7, 2, 'Fantastic sound quality.'),
                                                          (8, 8, 3, 'Very informative cookbook.'),
                                                          (9, 9, 4, 'Comfortable jeans.'),
                                                          (10, 10, 5, 'Powerful vacuum cleaner.');

