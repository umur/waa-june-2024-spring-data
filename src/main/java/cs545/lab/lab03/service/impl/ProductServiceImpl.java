package cs545.lab.lab03.service.impl;

import cs545.lab.lab03.entity.Category;
import cs545.lab.lab03.entity.Product;
import cs545.lab.lab03.repo.CategoryRepo;
import cs545.lab.lab03.repo.ProductRepo;
import cs545.lab.lab03.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    private final CategoryRepo categoryRepo;

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Optional<Product> getProductById(int id) {
        return productRepo.findById(id);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void deleteProductById(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public List<Product> findByPriceGreaterThan(double minPrice) {
        return productRepo.findByPriceGreaterThan(minPrice);
    }

    @Override
    public List<Product> findByNameAndPriceLessThan(String name, double maxPrice) {

        Category category = categoryRepo.findByName(name);
        List<Product> products = category.getProducts();
        products.removeIf(product -> product.getPrice() > maxPrice);

        return products;
    }

    @Override
    public List<Product> findByNameContaining(String keyword) {
        return productRepo.findByNameContaining(keyword);
    }
}
