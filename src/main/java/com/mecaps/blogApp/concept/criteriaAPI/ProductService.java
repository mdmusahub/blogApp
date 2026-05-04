package com.mecaps.blogApp.concept.criteriaAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductCriteriaRepository productRepository;

    public List<Products> search(String name, Double min, Double max, String category) {
        return productRepository.searchProducts(name, min, max, category);
    }
}