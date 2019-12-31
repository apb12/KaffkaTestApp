package com.alekseev.kaffka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employer {
    private Long id;
    private String name;
    private int age;

    public Employer(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
