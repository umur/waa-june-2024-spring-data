package edu.miu.springdata.config;

import edu.miu.springdata.contract.SaveProductReviewRequest;
import edu.miu.springdata.contract.SaveReviewRequest;
import edu.miu.springdata.domain.Review;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings(
                new PropertyMap<SaveReviewRequest, Review>() {
                    @Override
                    protected void configure() {
                        map().setComment(source.getComment());
                        // Explicitly skip setting ID, ProductId, and UserId
                        skip().setId(null);
                        skip().setProduct(null);
                        skip().setUser(null);
                    }
                });

        modelMapper.addMappings(
                new PropertyMap<SaveProductReviewRequest, Review>() {
                    @Override
                    protected void configure() {
                        map().setComment(source.getComment());
                        // Explicitly skip setting ID, ProductId, and UserId
                        skip().setId(null);
                        skip().setProduct(null);
                        skip().setUser(null);
                    }
                });

        return modelMapper;
    }
}
