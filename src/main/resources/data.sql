INSERT INTO `category` (name) VALUES ('Accessories');
INSERT INTO `product` (category_id, price, rating, name) VALUES (1, 100, 3, 'Rolex');
INSERT INTO `user` (email, first_name, last_name, password) VALUES ('info@miu.edu', 'Jones', 'Dan', 'Pass234');
INSERT INTO `address` (user_id, city, street, zip) VALUES (1, 'Iowa', 'Midleallo', '52557');
INSERT INTO `review` (product_id, rating, user_id, comment) VALUES (1, 4, 1, 'Very good');