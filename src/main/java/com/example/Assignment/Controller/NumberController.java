package com.example.Assignment.Controller;

import com.example.Assignment.Dto.FetchResponseDto;
import com.example.Assignment.Dto.NumberRequestDto;
import com.example.Assignment.Model.NumberEntity;
import com.example.Assignment.Repository.NumberRepository;
import com.example.Assignment.Service.NumberService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NumberController {

    @Autowired
    NumberService numberService;
    @Autowired
    NumberRepository numberRepository;

    @PostMapping("/Enter_Number")
    public ResponseEntity<String> EnterNumber(@RequestBody NumberRequestDto numberDto)
    {
        String response = numberService.EnterNumber(numberDto);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @GetMapping ("/FetchNextNumber/{id}")
    public NumberEntity fetchNextNumber(@PathVariable("id") int id)
    {
        return numberService.fetchNextNumber(id);
    }

}
