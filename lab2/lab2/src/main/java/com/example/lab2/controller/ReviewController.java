package com.example.lab2.controller;

import com.example.lab2.dto.ReviewDTO;
import com.example.lab2.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService service;

    @GetMapping
    public List<ReviewDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ReviewDTO getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping
    public ReviewDTO save(@RequestBody ReviewDTO review){
        return service.save(review);
    }

    @PutMapping("/{id}")
    public ReviewDTO update(@RequestBody ReviewDTO review,@PathVariable Long id){
        return service.update(id,review);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return service.delete(id);
    }
}