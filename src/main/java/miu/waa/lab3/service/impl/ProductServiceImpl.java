package miu.waa.lab3.service.impl;

import lombok.RequiredArgsConstructor;
import miu.waa.lab3.entity.Product;
import miu.waa.lab3.repository.ProductRepository;
import miu.waa.lab3.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existProduct = productRepository.findById(id).orElse(null);
        if(existProduct == null) return null;
        existProduct.setName(product.getName());
        existProduct.setPrice(product.getPrice());
        existProduct.setRating(product.getRating());
        return productRepository.save(existProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getProductsByMinPrice(Double minPrice) {
        return productRepository.findByPriceGreaterThan(minPrice);
    }

    @Override
    public List<Product> getProductsByCategoryNameAndMaxPrice(String categoryName, Double maxPrice) {
        return productRepository.findByCategoryNameAndPriceLessThan(categoryName, maxPrice);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepository.findByNameContaining(name);
    }
}
