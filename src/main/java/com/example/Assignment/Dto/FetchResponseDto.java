package com.example.Assignment.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FetchResponseDto {

    private int old_number;
    private int new_number;

    @Override
    public String toString() {
        return "FetchResponseDto{" +
                "old_number=" + old_number +
                ", new_number=" + new_number +
                '}';
    }
}
