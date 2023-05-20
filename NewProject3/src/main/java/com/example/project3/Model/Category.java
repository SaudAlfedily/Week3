package com.example.project3.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {

@NotNull(message = "Category id should not be null")
@Min(value = 100, message = "need to 3 digit")
@Max(value = 999, message = "need to 3 digit")
   private int id;


@NotNull(message = "Category nme should not be null")
@Size(min = 3,max = 3)
   private String name;


}
