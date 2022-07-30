package com.proj.books.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;
    private String content;
    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Book book;
    @ManyToOne
    @JoinColumn(name = "users_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;
    private Date datestamp;
}
