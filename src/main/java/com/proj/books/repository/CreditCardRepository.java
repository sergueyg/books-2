package com.proj.books.repository;

import com.proj.books.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
    @Query(value = "SELECT cr FROM CreditCard cr JOIN FETCH cr.user u WHERE u.id = :userid")
    List<CreditCard> getCreditCardByUserId(@Param("userid")Long userid);
}
