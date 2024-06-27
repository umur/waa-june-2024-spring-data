package waa.springdata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import waa.springdata.dto.ReviewDTO;
import waa.springdata.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public List<ReviewDTO> getAllReviews() {
        return reviewService.findAll();
    }

    @GetMapping("/products/{productId}")
    public List<ReviewDTO> getReviewsByProductId(@PathVariable int productId){
        return reviewService.findByProductId(productId);
    }

    @GetMapping("/{id}")
    public ReviewDTO getById(@PathVariable int id) {
        return reviewService.findById(id);
    }

    @PostMapping
    public ReviewDTO save(@RequestBody ReviewDTO reviewDTO) {
        return reviewService.save(reviewDTO);
    }

    @PutMapping("/{id}")
    public ReviewDTO updateById(@PathVariable int id, @RequestBody ReviewDTO reviewDTO) {
        return reviewService.update(id, reviewDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        reviewService.deleteById(id);
    }
}
