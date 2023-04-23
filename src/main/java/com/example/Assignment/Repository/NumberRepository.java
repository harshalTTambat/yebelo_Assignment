package com.example.Assignment.Repository;

import com.example.Assignment.Model.NumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface NumberRepository extends JpaRepository<NumberEntity,Integer> {

    @Modifying
    @Transactional
    @Query("update NumberEntity set numberChoice = :newNum where id =:tempId" )

    NumberEntity updateNumber(Integer tempId,int newNum);



    NumberEntity findByNewNumber(int xNumber);

}
