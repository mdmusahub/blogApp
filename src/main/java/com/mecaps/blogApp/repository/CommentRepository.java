package com.mecaps.blogApp.repository;

import com.mecaps.blogApp.concept.criteriaAPI.Products;
import com.mecaps.blogApp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {


    List<Comment> findByAuthor_Id(Long authorId);


    // JPQL
//    @Query("SELECT p.id, p.name.price FROM product p where p.name = ?1 AND p.price = ?2")
//    Products getProduct(String name, Double price);



    @Query(value = "SELECT p.id, p.price FROM product p where p.name = :name AND p.price = :price", nativeQuery = true)
    Products getProduct(@Param("name") String name, @Param("price") Double price);
}
