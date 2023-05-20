package com.example.project3.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyProduct {

    @NotNull(message = "Product id should not be null")
    @Min(value = 100, message = "need to 3 digit")
    @Max(value = 999, message = "need to 3 digit")
    private int id; //to search


    @NotEmpty(message = "product name can not be empty")
    @Size(min = 3, max = 3,message = "product name must be 3 ")
    private String name;

    @NotNull
    @Positive //try 0
    private double price;

    @NotNull(message = "Category id should not be null")
    @Min(value = 100, message = "need to 3 digit")
    @Max(value = 999, message = "need to 3 digit")
    private int categoryID;


}
