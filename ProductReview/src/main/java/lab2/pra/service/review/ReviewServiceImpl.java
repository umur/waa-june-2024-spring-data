package lab2.pra.service.review;

import lab2.pra.adapter.DtoAdapter;
import lab2.pra.domain.Category;
import lab2.pra.domain.Product;
import lab2.pra.domain.Review;
import lab2.pra.domain.User;
import lab2.pra.dto.ReviewDto;
import lab2.pra.repository.ReviewRepository;
import lab2.pra.service.product.ProductService;
import lab2.pra.service.review.ReviewService;
import lab2.pra.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;
    private final ProductService productService;
    private final UserService userService;

    @Override
    public List<ReviewDto> findAll() {
        return reviewRepository.findAll()
                .stream()
                .map(DtoAdapter.MAPPER::entityToDto)
                .toList();
    }

    @Override
    public ReviewDto save(ReviewDto reviewDto) {
        Review review = DtoAdapter.MAPPER.dtoToEntity(reviewDto);
        Product product = productService.findProductById(review.getProduct().getId());
        review.setProduct(product);
        reviewRepository.save(review);
        return DtoAdapter.MAPPER.entityToDto(review);
    }

    @Override
    public ReviewDto update(Integer id, ReviewDto reviewDto) {
        Review reviewById = findReviewById(id);
        Product product = productService.findProductById(reviewDto.getProduct().getId());
        User user = userService.findUserById(reviewDto.getUser().getId());
        reviewById.setUser(user);
        reviewById.setProduct(product);
        reviewById.setComment(reviewDto.getComment());
        reviewRepository.save(reviewById);
        return DtoAdapter.MAPPER.entityToDto(reviewById);
    }

    @Override
    public boolean delete(Integer id) {
        Review review = findReviewById(id);
        reviewRepository.delete(review);
        return true;
    }

    @Override
    public ReviewDto findById(Integer id) {
        return DtoAdapter.MAPPER.entityToDto(findReviewById(id));
    }

    @Override
    public Review findReviewById(Integer id) {
        Optional<Review> reviewOpt=reviewRepository.findById(id);
        if(reviewOpt.isEmpty()){
            throw new RuntimeException("No review Found");
        }
        return reviewOpt.get();
    }

    @Override
    public List<ReviewDto> findByProduct(Integer productId) {
        Product product = productService.findProductById(productId);
        return product.getReviews()
                .stream()
                .map(DtoAdapter.MAPPER::entityToDto).toList();
    }
}
