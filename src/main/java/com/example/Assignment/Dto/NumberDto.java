package com.example.Assignment.Dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class NumberDto {

    @Column(nullable = false)
    private int number;
}
