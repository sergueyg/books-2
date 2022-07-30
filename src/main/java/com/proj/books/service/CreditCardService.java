package com.proj.books.service;

import com.proj.books.model.CreditCard;
import com.proj.books.repository.CreditCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService {
    private final CreditCardRepository creditCardRepository;

    public CreditCardService(CreditCardRepository creditCardRepository){
        this.creditCardRepository = creditCardRepository;
    }

    public CreditCard addCreditCard(CreditCard creditCard){
        return creditCardRepository.save(creditCard);
    }

    public List<CreditCard> getCreditCardByUserId(Long id){
        return creditCardRepository.getCreditCardByUserId(id);
    }
}
