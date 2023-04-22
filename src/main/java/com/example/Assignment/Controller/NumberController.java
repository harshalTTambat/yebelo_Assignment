package com.example.Assignment.Controller;

import com.example.Assignment.Dto.NumberDto;
import com.example.Assignment.Service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NumberController {

    @Autowired
    NumberService numberService;

    @PostMapping("/Enter_Number")
    public void EnterNumber(@RequestBody NumberDto numberDto)
    {

    }
}
