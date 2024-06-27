package com.example.springdata.controller;

import com.example.springdata.entity.User;
import com.example.springdata.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> getAll() {
		return ResponseEntity.ok().body(userService.getAll());
	}

	@PostMapping
	public ResponseEntity<User> createOne(@RequestBody User user) {
		User item = userService.createOne(user);
		return ResponseEntity.ok().body(item);
	}


	@PutMapping("/{id}")
	public ResponseEntity<?> updateOne(@RequestBody User user, @PathVariable String id) {
		User item = userService.updateOne(id, user).orElse(null);
		if (item == null) {
			return ResponseEntity.badRequest().body("User not found!");
		}
		return ResponseEntity.ok().body(item);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteOne(@PathVariable String id) {
		User item = userService.deleteOne(id).orElse(null);
		if (item == null) {
			return ResponseEntity.badRequest().body("User not found!");
		}
		return ResponseEntity.ok().body(item);
	}
}
