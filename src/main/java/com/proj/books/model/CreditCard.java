package com.proj.books.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private BigDecimal balance;
    private String brand;
    @ManyToOne
    @JoinColumn(name = "users_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;
}
