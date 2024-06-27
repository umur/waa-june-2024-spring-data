package com.example.Spring_Data;

import com.example.Spring_Data.entity.*;
import com.example.Spring_Data.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			ProductService productService,
			CategoryService categoryService,
			UserService userService,
			AddressService addressService,
			ReviewService reviewService
	){
		return args -> {
			var address1 = Address.builder()
					.city("Harare")
					.street("1234")
					.zip("1234")
					.build();
			addressService.createAddress(address1);

			var address2 = Address.builder()
					.city("Bulawayo")
					.street("1234")
					.zip("1234")
					.build();
			addressService.createAddress(address2);

			var user1 = User.builder()
					.fname("John")
					.lname("Doe")
					.email("john@emai.com")
					.password("1234")
					.address(address1)
					.build();
			userService.createUser(user1);

			var user2 = User.builder()
					.fname("Jane")
					.lname("Doe")
					.email("jane@email.com")
					.password("1234")
					.address(address2)
					.build();
			userService.createUser(user2);

			var category1 = Category.builder()
					.name("Electronics")
					.build();
			categoryService.createCategory(category1);

			var category2 = Category.builder()
					.name("Clothing")
					.build();
			categoryService.createCategory(category2);

			var product1 = Product.builder()
					.name("Laptop")
					.price(1000)
					.rating(5)
					.category(category1)
					.build();
			productService.createProduct(product1);

			var product2 = Product.builder()
					.name("T-shirt")
					.price(20)
					.rating(4)
					.category(category2)
					.build();
			productService.createProduct(product2);

			var product3 = Product.builder()
					.name("Mobile Phone")
					.price(500)
					.rating(4)
					.category(category1)
					.build();
			productService.createProduct(product3);

			var product4 = Product.builder()
					.name("Jeans")
					.price(50)
					.rating(3)
					.category(category2)
					.build();
			productService.createProduct(product4);

			var product5 = Product.builder()
					.name("Tablet")
					.price(300)
					.rating(4)
					.category(category1)
					.build();
			productService.createProduct(product5);

			var review1 = Review.builder()
					.comment("Good product")
					.product(product1)
					.user(user1)
					.build();
			reviewService.createReview(review1);

			var review2 = Review.builder()
					.comment("Bad product")
					.product(product2)
					.user(user2)
					.build();
			reviewService.createReview(review2);

			var review3 = Review.builder()
					.comment("Good product")
					.product(product3)
					.user(user1)
					.build();
			reviewService.createReview(review3);

			var review4 = Review.builder()
					.comment("Bad product")
					.product(product4)
					.user(user2)
					.build();
			reviewService.createReview(review4);

			var review5 = Review.builder()
					.comment("Good product")
					.product(product5)
					.user(user1)
					.build();
		};
	}
}
