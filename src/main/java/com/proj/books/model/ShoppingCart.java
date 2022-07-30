package com.proj.books.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "shoppingcart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "shoppingcart_id")
    private long id;
    @OneToOne
    @JoinColumn(name = "users_id")
    private User user;
    @OneToMany(mappedBy = "shoppingCart")
    private List<Book> books;
}
