package com.mecaps.blogApp.concept;

import com.mecaps.blogApp.concept.criteriaAPI.Products;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DemoCriteriaAPIClass {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Products> getProducts(){

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Products> criteriaQuery = criteriaBuilder.createQuery(Products.class);

        Root<Products> root = criteriaQuery.from(Products.class);

        Predicate equal = criteriaBuilder.equal(root.get("name"), "Laptop");


        criteriaQuery.select(root).where(equal);

        TypedQuery<Products> query = entityManager.createQuery(criteriaQuery);


        return query.getResultList();


    }

}
