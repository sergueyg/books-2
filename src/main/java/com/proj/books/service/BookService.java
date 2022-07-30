package com.proj.books.service;

import com.proj.books.model.Book;
import com.proj.books.repository.BookRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooksByGenre(String genre){
        return bookRepository.findByGenre(genre);
    }

    public List<Book> getBooksByPosition(long position){
        return bookRepository.getAllBooksWithStartingPosition(position);
    }

    public List<Book> getTopTenBooks(){
        return bookRepository.getTopTenBooks(PageRequest.of(0, 10));
    }

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }
}
