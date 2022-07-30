package com.proj.books.service;

import com.proj.books.model.CombinedRatingsComments;
import com.proj.books.model.Comment;
import com.proj.books.model.Ratings;
import com.proj.books.repository.RatingsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RatingsService {
    private final RatingsRepository ratingsRepository;
    private final CommentService commentService;

    public RatingsService(RatingsRepository ratingsRepository, CommentService commentService){
        this.ratingsRepository = ratingsRepository;
        this.commentService = commentService;
    }

    public Ratings addRating(Ratings rating){
        rating.setDatestamp(new Date(System.currentTimeMillis()));
        return ratingsRepository.save(rating);
    }

    public List<Ratings> getRatingsByUserId(Long userid){
        return ratingsRepository.findByUserId(userid);
    }

    public List<Ratings> getRatingsByRating(int rating){
        return ratingsRepository.findByRating(rating);
    }

    public List<Ratings> getRatingsByBookId(Long bookId){
        return ratingsRepository.findByBookId(bookId);
    }

    public double getAverageRatingForBook(Long bookId){
        List<Ratings> ratings = getRatingsByBookId(bookId);
        int totalRatings = ratings.size();
        int sumRatings = 0;
        for(Ratings rating : ratings){
            sumRatings += rating.getRating();
        }
        if(totalRatings == 0)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return (double)sumRatings/(double)totalRatings;
    }

    public List<CombinedRatingsComments> getCombinedByBookId(){
        Map<Long, Comment> commentsByBook = commentService.getAll().stream().collect(Collectors.toMap(key ->
                key.getBook().getId(), value -> value));
        List<Ratings> allRatings = getAll();
        List<CombinedRatingsComments> combined = new LinkedList<>();
        for(Ratings rating : allRatings){
            combined.add(CombinedRatingsComments.builder().rating(rating).comment(commentsByBook.get(rating.getBook().getId())).build());
        }
        return combined.stream().sorted((val1, val2) -> Integer.compare(val2.getRating().getRating(), val1.getRating().getRating())).toList();
    }

    public List<Ratings> getAll(){
        return ratingsRepository.findAll();
    }
}
