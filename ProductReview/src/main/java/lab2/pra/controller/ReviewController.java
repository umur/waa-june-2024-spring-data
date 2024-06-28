package lab2.pra.controller;

import lab2.pra.dto.ReviewDto;
import lab2.pra.service.review.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public List<ReviewDto> getAll() {
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public ReviewDto getById(@PathVariable Integer id) {
        return reviewService.findById(id);
    }

    @PostMapping
    public ReviewDto save(@RequestBody ReviewDto review) {
        return reviewService.save(review);
    }

    @PutMapping("/{id}")
    public ReviewDto update(@RequestBody ReviewDto review, @PathVariable Integer id) {
        return reviewService.update(id, review);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return reviewService.delete(id);
    }
}
