package com.example.homework14.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
public class MyEmployee {
    final String supervisor = "supervisor";
    final String coordinator = "coordinator";

    @NotEmpty(message = "id can not be empty")
    @Size(min = 3, message = "you need to enter more than 2")
    private String id; //more than 2 so 2 is not acceptable


    @NotEmpty(message = "name can not be empty")
    @Size(min = 5, message = "you need to enter more than 4")
    private String name; //more than 4 so 4 is not acceptable


    @NotNull(message = "age can not be empty")
    @Positive(message = "you need to enter a positive number")
    @Min(value = 26, message = "you need to bee older than 25")
    private int age; //more than 25 so 25 is not acceptable


    @Pattern(regexp = "^(" + supervisor + "|" + coordinator + ")", message = "not exciting position ")
    @NotEmpty(message = "you need to enter a position")
    private String position;

    @AssertFalse(message = "the employee is on leave")
    boolean onLeave;


    @NotNull(message = "you did not enter a date")
    @PastOrPresent(message = "the date is not vaild")
    private LocalDate employmentYear;


    @PositiveOrZero(message = "you need to enter positive number ")
    @NotNull(message = "you need to enter annul leave")
    int annualLeave;


}
