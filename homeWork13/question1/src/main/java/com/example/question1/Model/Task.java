package com.example.question1.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Task {
    String id;
    String title;
    String description;
    String status;

}
