package com.example.Assignment.Service;

import com.example.Assignment.Dto.NumberRequestDto;
import com.example.Assignment.Model.NumberEntity;
import com.example.Assignment.Repository.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NumberService {
    @Autowired
    NumberRepository numberRepository;

    public String EnterNumber(NumberRequestDto numberDto)
    {
        NumberEntity xNumber = NumberEntity.builder().
                number(numberDto.getNumber())
                .build();

        try {
            numberRepository.save(xNumber);
        }catch (Exception e)
        {
            return "Number is not saved";
        }
        return "number save successfully";
    }
}
