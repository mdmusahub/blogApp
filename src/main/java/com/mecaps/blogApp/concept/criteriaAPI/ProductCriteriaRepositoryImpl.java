package com.mecaps.blogApp.concept.criteriaAPI;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ProductCriteriaRepositoryImpl  implements ProductRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    public List<Products> searchProducts(String name, Double minPrice, Double maxPrice, String category) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Products> query = cb.createQuery(Products.class);

        Root<Products> root = query.from(Products.class);


        List<Predicate> predicates = new ArrayList<>();

        if (name != null) {
            predicates.add(cb.equal(root.get("name"),name));
        }
        if (minPrice != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("price"), minPrice));
        }
        if (maxPrice != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("price"), maxPrice));
        }
        if (category != null) {
            predicates.add(cb.equal(root.get("category"), category));
        }
        // Apply conditions
         query.where(cb.and(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(query).getResultList();



    }

}
