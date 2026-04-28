package com.mecaps.blogApp.repository;

import com.mecaps.blogApp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {


    List<Comment> findByAuthor_Id(Long authorId);
}
