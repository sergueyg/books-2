package com.proj.books.repository;

import com.proj.books.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBookId(Long id);
    List<Comment> findByUserId(Long id);
}
