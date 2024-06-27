package waa.springdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import waa.springdata.dto.ReviewAdapter;
import waa.springdata.dto.ReviewDTO;
import waa.springdata.entity.Product;
import waa.springdata.entity.Review;
import waa.springdata.entity.User;
import waa.springdata.repository.ProductRepository;
import waa.springdata.repository.ReviewRepository;
import waa.springdata.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<ReviewDTO> findAll() {
        return reviewRepository.findAll()
                .stream()
                .map(ReviewAdapter::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public List<ReviewDTO> findByProductId(int productId) {
        return reviewRepository.findByProductId(productId)
                .stream()
                .map(ReviewAdapter::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public ReviewDTO findById(int id) {
        return reviewRepository.findById(id)
                .map(ReviewAdapter::toDTO)
                .orElse(null);
    }

    @Override
    public ReviewDTO save(ReviewDTO reviewDTO) {
        Review review = ReviewAdapter.toEntity(reviewDTO);
        Product product = productRepository.findById(reviewDTO.getProductId()).orElseThrow();
        User user = userRepository.findById(reviewDTO.getUserId()).orElseThrow();
        review.setProduct(product);
        review.setUser(user);
        return ReviewAdapter.toDTO(reviewRepository.save(review));
    }

    @Override
    public ReviewDTO update(int id, ReviewDTO reviewDTO) {
        if (reviewRepository.existsById(id)) {
            Review review = ReviewAdapter.toEntity(reviewDTO);
            Product product = productRepository.findById(reviewDTO.getProductId()).orElseThrow();
            User user = userRepository.findById(reviewDTO.getUserId()).orElseThrow();
            review.setProduct(product);
            review.setUser(user);
            review.setId(id); // Ensure the ID is set for update
            return ReviewAdapter.toDTO(reviewRepository.save(review));
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        reviewRepository.deleteById(id);
    }
}
