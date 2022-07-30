package com.proj.books.controller;

import com.proj.books.model.CombinedRatingsComments;
import com.proj.books.model.Ratings;
import com.proj.books.service.CommentService;
import com.proj.books.service.RatingsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingsController {
    private final RatingsService ratingsService;
    private final CommentService commentService;

    public RatingsController(RatingsService ratingsService, CommentService commentService){
        this.ratingsService = ratingsService;
        this.commentService = commentService;
    }

    @PostMapping
    public Ratings addRating(@RequestBody Ratings rating){
        if(rating == null || rating.getRating() < 0 || rating.getRating() > 5)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return ratingsService.addRating(rating);
    }

    @GetMapping(value = "/userid/{userid}")
    public List<Ratings> getRatingsByUserId(@PathVariable(name = "userid")Long userid){
        return ratingsService.getRatingsByUserId(userid);
    }

    @GetMapping(value = "/{rating}")
    public List<Ratings> getRatingsByUserId(@PathVariable(name = "rating")int rating){
        return ratingsService.getRatingsByRating(rating);
    }

    @GetMapping(value = "/bookid/{bookid}")
    public List<Ratings> getRatingsByBookId(@PathVariable(name = "bookid")Long bookId){
        return ratingsService.getRatingsByBookId(bookId);
    }

    @GetMapping("/averagerating/{bookid}")
    public Double getAverageRatingForBook(@PathVariable(name = "bookid")Long bookId){
        return ratingsService.getAverageRatingForBook(bookId);
    }

    @GetMapping("/combined")
    public List<CombinedRatingsComments> getCombinedByBookId(){
        return ratingsService.getCombinedByBookId();
    }
}
