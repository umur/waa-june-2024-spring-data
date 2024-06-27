package edu.miu.waajune2024springdata.service.impl;

import edu.miu.waajune2024springdata.dto.ProductDto;
import edu.miu.waajune2024springdata.dto.ReviewDto;
import edu.miu.waajune2024springdata.entity.Product;
import edu.miu.waajune2024springdata.entity.Review;
import edu.miu.waajune2024springdata.entity.User;
import edu.miu.waajune2024springdata.mapper.DtoMapper;
import edu.miu.waajune2024springdata.repository.ReviewRepository;
import edu.miu.waajune2024springdata.service.ProductService;
import edu.miu.waajune2024springdata.service.ReviewService;
import edu.miu.waajune2024springdata.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author kush
 */
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository repo;
    private final UserService userService;
    private final ProductService productService;
    @Override
    public List<ReviewDto> getAll() {
        return repo.findAll().stream().map(DtoMapper.MAPPER::entityToDto).toList();
    }

    @Override
    public ReviewDto getById(Long id) {
        return DtoMapper.MAPPER.entityToDto(getReviewById(id));
    }

    @Override
    public Review getReviewById(Long id) {
        Optional<Review> reviewOpt=repo.findById(id);
        if(reviewOpt.isEmpty()){
            throw new RuntimeException("No review Found");
        }
        return reviewOpt.get();
    }

    @Override
    public ReviewDto save(ReviewDto reviewDto) {
        Review review=DtoMapper.MAPPER.dtoToEntity(reviewDto);
        Product product=productService.getProductById(review.getProduct().getId());
        User user=userService.getUserById(review.getUser().getId());
        review.setProduct(product);
        review.setUser(user);
        return DtoMapper.MAPPER.entityToDto(repo.save(review));
    }

    @Override
    public ReviewDto update(Long id, ReviewDto reviewDto) {
        Optional<Review> reviewOpt=repo.findById(id);
        if(reviewOpt.isEmpty()){
            throw new RuntimeException("No reviewDto Found");
        }
        Product product=productService.getProductById(reviewDto.getProduct().getId());
        User user=userService.getUserById(reviewDto.getUser().getId());
        Review savedReview=reviewOpt.get();
        savedReview.setProduct(product);
        savedReview.setUser(user);
        savedReview.setComment(reviewDto.getComment());

        repo.save(savedReview);
        return DtoMapper.MAPPER.entityToDto(savedReview);
    }

    @Override
    public boolean delete(Long id) {
        Optional<Review> reviewOpt=repo.findById(id);
        if(reviewOpt.isEmpty()){
            throw new RuntimeException("No review Found");
        }
        repo.delete(reviewOpt.get());
        return true;
    }

    @Override
    public List<ReviewDto> findByProduct(Long productId){
        Product product=productService.getProductById(productId);
        return repo.findByProduct(product).stream().map(DtoMapper.MAPPER::entityToDto).toList();
    }

}
