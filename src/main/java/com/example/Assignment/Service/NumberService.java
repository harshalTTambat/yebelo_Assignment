package com.example.Assignment.Service;

import com.example.Assignment.Dto.NumberDto;
import com.example.Assignment.Repository.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NumberService {
    @Autowired
    NumberRepository numberRepository;

    public void EnterNumber(NumberDto numberDto)
    {

    }
}
