package waa.springdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import waa.springdata.entity.Product;
import waa.springdata.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByGreaterThanMinPrice(double price) {
        return productRepository.findByPriceGreaterThan(price);
    }

    @Override
    public List<Product> findByCategoryAndCostLessThan(String category,double price){
        return productRepository.findByCategoryNameAndPriceLessThan(category,price);
    }

    @Override
    public List<Product> findByNameKeyword(String name){
        return productRepository.findByNameContaining(name);
    }
    @Override
    public Product findById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
    @Override
    public Product update(int id,Product product){
        if(productRepository.existsById(id)){
            return productRepository.save(product);
        }
        return null;
    }
    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }
}
