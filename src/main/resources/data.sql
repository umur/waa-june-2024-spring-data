insert into user (id,email,password,first_name,last_name) value (1, 'abc.com', '123', 'David', 'Smith');

insert into category (id,name) value (1, 'Electronic');

insert into product (id,name,price,rating,category_id) value (1, 'MacBook M3', 999.99, 9.5, 1);

insert into review (id,comment,user_id,product_id) value (1, 'Good', 1, 1);

insert into address (id,street,zip,city,user_id) value (1, '1000N', 'FairField', '4th Street',1);

update user set address_id=1 where id=1;