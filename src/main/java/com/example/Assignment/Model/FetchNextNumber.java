package com.example.Assignment.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "old_new_number")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FetchNextNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int oldNum;

    private int newNum;

}
