package com.example.Assignment.Controller;

import com.example.Assignment.Dto.FetchResponseDto;
import com.example.Assignment.Dto.NumberRequestDto;
import com.example.Assignment.Service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NumberController {

    @Autowired
    NumberService numberService;

    @PostMapping("/Enter_Number")
    public String EnterNumber(@RequestBody NumberRequestDto numberDto)
    {
        return numberService.EnterNumber(numberDto);
    }

    @GetMapping("/FetchNextNumber/{id}")
    public FetchResponseDto fetchNextNumber(@RequestParam("id") int id)
    {
        return numberService.fetchNextNumber(id);
    }
}
