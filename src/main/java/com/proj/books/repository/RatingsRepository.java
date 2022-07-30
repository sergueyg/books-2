package com.proj.books.repository;

import com.proj.books.model.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingsRepository extends JpaRepository<Ratings, Long> {
    List<Ratings> findByRating(int rating);
    List<Ratings> findByUserId(Long id);
    List<Ratings> findByBookId(Long id);
}
