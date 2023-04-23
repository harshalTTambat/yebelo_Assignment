package com.example.Assignment.Dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class NumberRequestDto {

    @Column(nullable = false)
    private int numberChoice;
}
