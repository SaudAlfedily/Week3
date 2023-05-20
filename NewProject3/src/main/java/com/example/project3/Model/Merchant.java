package com.example.project3.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Merchant {

    @NotNull(message = "Merchant id should not be null")
    @Min(value = 100, message = "need to 3 digit")
    @Max(value = 999, message = "need to 3 digit")
    private int id;


    @NotEmpty(message = "Category nme should not be null")
    @Size(min = 3,max = 3)
    private String name;
}
