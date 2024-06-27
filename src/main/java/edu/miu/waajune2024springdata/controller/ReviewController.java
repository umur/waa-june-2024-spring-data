package edu.miu.waajune2024springdata.controller;

import edu.miu.waajune2024springdata.dto.ReviewDto;
import edu.miu.waajune2024springdata.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kush
 */
@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService service;

    @GetMapping
    public List<ReviewDto> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ReviewDto getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping
    public ReviewDto save(@RequestBody ReviewDto review){
        return service.save(review);
    }

    @PutMapping("/{id}")
    public ReviewDto update(@RequestBody ReviewDto review,@PathVariable Long id){
        return service.update(id,review);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return service.delete(id);
    }
}
