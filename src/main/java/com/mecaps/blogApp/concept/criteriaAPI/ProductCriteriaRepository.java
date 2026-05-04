package com.mecaps.blogApp.concept.criteriaAPI;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductCriteriaRepository extends JpaRepository<Products, Long>,
        ProductRepositoryCustom {

}
