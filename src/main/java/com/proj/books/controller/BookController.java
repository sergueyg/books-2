package com.proj.books.controller;

import com.proj.books.model.Book;
import com.proj.books.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/genre/{genre}")
    public List<Book> getBooksByGenre(@PathVariable(name = "genre") String genre){
        return bookService.getBooksByGenre(genre);
    }

    @GetMapping("/topsellers")
    public List<Book> getTopSellers(){
        return bookService.getTopTenBooks();
    }

    @GetMapping("/position/{position}")
    public List<Book> getBooksByPosition(@PathVariable(name = "position")long position){
        return bookService.getBooksByPosition(position);
    }

    @PostMapping
    public Book postBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }
}
