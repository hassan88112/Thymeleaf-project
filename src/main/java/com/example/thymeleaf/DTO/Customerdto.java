package com.example.thymeleaf.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customerdto {

    private Long id;
    private String firstName;

    private String lastName;

    private String email;

    private Long price;
}
