INSERT INTO my_spring_data.category (name) VALUES
	 (1, 'Category 1'),
	 (2, 'Category 2'),
	 (3, 'Category 3');
INSERT INTO my_spring_data.product (price,rating,category_id,name) VALUES
	 (1000.0,5.0,1,'Product 1'),
	 (2000.0,5.0,1,'Product 2'),
	 (3000.0,5.0,2,'Product 3'),
	 (4000.0,5.0,3,'Product 4'),
	 (5000.0,5.0,3,'Product 5');
INSERT INTO my_spring_data.`user` (address_id,email,first_name,last_name,password) VALUES
	 (1,'myemail@gmail.com','Hello','World','123456'),
	 (2,'myemail+01@gmail.com','Hello 01','World 01','123456'),
	 (3,'myemail+02@gmail.com','Hello 02','World 02','123456');
INSERT INTO my_spring_data.address (city,street,zip) VALUES
	 ('Fairfield','Main','52556'),
	 ('Fairfield','Main','52557'),
	 ('Fairfield','Main','52558');
INSERT INTO my_spring_data.review (product_id,user_id,comment) VALUES
	 (1,1,'Comment 1'),
	 (1,2,'Comment 2'),
	 (1,3,'Comment 3');
     