insert into address (id, city, street, zip) VALUES  (1, "Fairfield", "1000 N 4th Street", 525557);
insert into address (id, city, street, zip) VALUES  (2, "Ottumwa", "200 T Street", 5226);
insert into address (id, city, street, zip) VALUES  (3, "Ottumwa", "200 T Street", 5226);
insert into address (id, city, street, zip) VALUES  (4, "AXGS", "9999 T Street", 5226);
--
insert into category (id, name) values  (14, "stage");
insert into category (id, name) values  (13, "city");
insert into category (id, name) values  (12, "Annial");
insert into category (id, name) values  (11, "cat");
insert into category (id, name) values  (10, "string");
insert into category (id, name) values  (9, "test5");
insert into category (id, name) values  (8, "test4");
insert into category (id, name) values  (7, "test3");
insert into category (id, name) values  (6, "test2");
insert into category (id, name) values  (5, "test1");
insert into category (id, name) values  (4, "Desert");
insert into category (id, name) values  (3, "Side");
insert into category (id, name) values  (2, "Drink");
insert into category (id, name) values  (1, "food");
--
insert into user (id, email, first_name, last_name, password, address_id) values (1, "aaaaa@gmail.com", "A", "B", "123445", 1);
insert into user (id, email, first_name, last_name, password, address_id) values (2, "testgmail.com", "Toan", "Nguyen", "123445", 2);
insert into user (id, email, first_name, last_name, password, address_id) values (3, "bbbb@gmail.com", "Btest", "Btest", "123445", 3);
insert into user (id, email, first_name, last_name, password, address_id) values (4, "abc@gmail.com", "Ctest", "Ctest", "123445", 4);
--
insert into product (id, name, price, rating, category_id) values  (1, "Change Product 1 into 1a", 11.25, 1, 1);
insert into product (id, name, price, rating, category_id) values  (2, "Product 2", 20.5, 3, 2);
insert into product (id, name, price, rating, category_id) values  (3, "Product 3", 14.25, 5, 4);
insert into product (id, name, price, rating, category_id) values  (4, "New Product X", 13.25, 5, 11);
insert into product (id, name, price, rating, category_id) values  (5, "New Product Y", 9.99, 3, 6);
--
insert into review (id, comment, product_id, user_id) values  (1, "Add your name in the body", 2, 2);
insert into review (id, comment, product_id, user_id) values  (2, "Add your name in the body", 1, 1);
insert into review (id, comment, product_id, user_id) values  (3, "Add your name in the body", 1, 1);
insert into review (id, comment, product_id, user_id) values  (4, "Add your name in the body", 1, 1);
insert into review (id, comment, product_id, user_id) values  (5, "Comment 3", 2, 2);
insert into review (id, comment, product_id, user_id) values  (6, "Comment 2", 2, 2);
insert into review (id, comment, product_id, user_id) values  (7, "Comment 4", 2, 2);
insert into review (id, comment, product_id, user_id) values  (8, "Comment 736464", 2, 1);
insert into review (id, comment, product_id, user_id) values  (9, "I have a complain for product 1121", 1, 1);
insert into review (id, comment, product_id, user_id) values  (10, "I have a complain for product 1121", 1, 1);
insert into review (id, comment, product_id, user_id) values  (11, "I have a complain for product 1121", 1, 1);
insert into review (id, comment, product_id, user_id) values  (12, "I have a complain for product 1121", 1, 1);
insert into review (id, comment, product_id, user_id) values  (13, "I have a complain for product 1121", 1, 1);
--
insert into product_reviews (product_id, reviews_id) values  (1, 9);
insert into product_reviews (product_id, reviews_id) values  (1, 10);
insert into product_reviews (product_id, reviews_id) values  (1, 11);
insert into product_reviews (product_id, reviews_id) values  (1, 12);
insert into product_reviews (product_id, reviews_id) values  (1, 13);
insert into product_reviews (product_id, reviews_id) values  (2, 7);
insert into product_reviews (product_id, reviews_id) values  (2, 8);
--
