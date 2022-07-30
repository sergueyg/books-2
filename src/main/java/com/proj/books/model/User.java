package com.proj.books.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "users_id")
    private long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    private String name;
    private String email;
    private String homeAddress;
    @OneToMany(mappedBy = "user")
    private List<CreditCard> creditCard;
    @OneToMany(mappedBy = "user")
    private List<Ratings> ratings;
    @OneToMany(mappedBy = "user")
    private List<Comment> comments;
    @OneToOne
    @JoinColumn(name = "shoppingcart_id")
    private ShoppingCart shoppingCart;
}
