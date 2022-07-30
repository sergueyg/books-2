package com.proj.books.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class Ratings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ratings_id")
    private long id;
    private int rating;
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
