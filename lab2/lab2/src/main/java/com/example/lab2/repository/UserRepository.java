package com.example.lab2.repository;

import com.example.lab2.entity.Review;
import com.example.lab2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

}
