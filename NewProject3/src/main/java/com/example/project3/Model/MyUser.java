package com.example.project3.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MyUser {

    private final String Admin="Admin";
    private final String Customer="Customer";

    @NotNull(message = "user id should not be null")
    @Min(value = 100, message = "need to 3 digit")
    @Max(value = 999, message = "need to 3 digit")
    private int id;


    @NotEmpty(message = "user name should not be empty")
    @Size(min = 5, max = 5, message = "user name should be 5 ")
    private String username;


    @NotEmpty(message = "password can not be empty")
    @Size(min = 6, max = 6, message = "password size should be 6")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-zA-Z]).{4,8}$", message = "password must have characters and digits")
    //must have characters and digits ).
    private String password;


    @NotEmpty(message = "email should not not empty")
    @Email(message = "not vaild email")
    private String email;

    @NotEmpty(message = "role should not be empty")
    @Pattern(regexp = "^(" + Admin + "|" + Customer + ")",message = "not valid role have to be in ( “Admin”,”Customer”) ).") //have to be in ( “Admin”,”Customer”) ).
    private String role;


    @NotNull
    @Positive
    private double balance ;


}
