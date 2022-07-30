package com.proj.books.controller;

import com.proj.books.model.Comment;
import com.proj.books.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @PostMapping
    public Comment addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }

    @GetMapping("/bookid/{bookid}")
    public List<Comment> getCommentsByBookId(@PathVariable(name = "bookid")Long bookId){
        return commentService.getCommentsByBookId(bookId);
    }

    @GetMapping("/userid/{userid}")
    public List<Comment> getCommentsByUserId(@PathVariable("userid")Long userId){
        return commentService.getCommentsByUserId(userId);
    }
}
