package com.example.thymeleaf.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customerdto {

    private Long id;
    private String firstName;

    private String lastName;

    private String email;

    private Long price;

    private LocalDate date;

    private LocalDate statDate;

    private LocalDate endDate;
}
