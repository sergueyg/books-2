package com.proj.books.repository;

import com.proj.books.model.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByGenre(String genre);
    @Query(value = "SELECT b FROM Book b ORDER BY b.copiesSold DESC")
    List<Book> getTopTenBooks(Pageable page);
    @Query(value = "SELECT b FROM Book b WHERE b.id >= :position")
    List<Book> getAllBooksWithStartingPosition(long position);
}
