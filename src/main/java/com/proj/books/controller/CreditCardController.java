package com.proj.books.controller;

import com.proj.books.model.CreditCard;
import com.proj.books.service.CreditCardService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/card")
public class CreditCardController {
    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService){
        this.creditCardService = creditCardService;
    }

    @PostMapping
    public CreditCard addCreditCard(@RequestBody CreditCard creditCard){
        if(creditCard == null || creditCard.getUser() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return creditCardService.addCreditCard(creditCard);
    }

    @GetMapping("/{userid}")
    public List<CreditCard> getCreditCardByUserId(@PathVariable(name = "userid")Long userid){
        return creditCardService.getCreditCardByUserId(userid);
    }
}
