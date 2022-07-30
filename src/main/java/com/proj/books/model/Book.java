package com.proj.books.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "book")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private long id;
    private String title;
    private String genre;
    private int copiesSold;
    @ManyToOne
    @JoinColumn(name = "shoppingcart_id")
    private ShoppingCart shoppingCart;
    @OneToMany(mappedBy = "book")
    private List<Ratings> ratings;
    @OneToMany(mappedBy = "book")
    private List<Comment> comments;
}
