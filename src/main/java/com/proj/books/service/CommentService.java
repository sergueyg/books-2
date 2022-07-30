package com.proj.books.service;

import com.proj.books.model.Comment;
import com.proj.books.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    public List<Comment> getCommentsByBookId(Long bookId){
        return commentRepository.findByBookId(bookId);
    }

    public List<Comment> getCommentsByUserId(Long userId){
        return commentRepository.findByUserId(userId);
    }

    public Comment addComment(Comment comment){
        comment.setDatestamp(new Date(System.currentTimeMillis()));
        return commentRepository.save(comment);
    }

    public List<Comment> getAll(){
        return commentRepository.findAll();
    }
}
