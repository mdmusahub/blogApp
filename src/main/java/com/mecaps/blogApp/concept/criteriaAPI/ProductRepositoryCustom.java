package com.mecaps.blogApp.concept.criteriaAPI;

import java.util.List;



public interface ProductRepositoryCustom {

    List<Products> searchProducts(String name,
                                  Double minPrice,
                                  Double maxPrice,
                                  String category);




}
