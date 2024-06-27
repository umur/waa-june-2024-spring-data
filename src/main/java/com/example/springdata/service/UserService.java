package com.example.springdata.service;

import com.example.springdata.entity.Address;
import com.example.springdata.entity.User;
import com.example.springdata.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	private final AddressService addressService;

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public User createOne(User u) {
		Address address = addressService.createOne(u.getAddress());
		u.setAddress(address);
		return userRepository.save(u);
	}

	public Optional<User> updateOne(String id, User u) {
		User item = userRepository.findById(id).orElse(null);
		if (item == null) {
			return Optional.empty();
		}

		item.setAddress(u.getAddress());
		item.setReviews(u.getReviews());
		item.setEmail(u.getEmail());
		item.setPassword(u.getPassword());
		item.setFirstName(u.getFirstName());
		item.setLastName(u.getLastName());

		return Optional.of(userRepository.save(u));
	}

	public Optional<User> deleteOne(String id) {
		User item = userRepository.findById(id).orElse(null);
		if (item == null) {
			return Optional.empty();
		}
		userRepository.deleteById(id);
		return Optional.of(item);
	}
}
