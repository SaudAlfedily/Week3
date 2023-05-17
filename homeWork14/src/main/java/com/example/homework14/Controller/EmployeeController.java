package com.example.homework14.Controller;

import com.example.homework14.ApiResponse.ApiResponse;
import com.example.homework14.Model.MyEmployee;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {


    ArrayList<MyEmployee> employees = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList getEmployee() {

        return employees;


    }


    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody MyEmployee myEmployee, Errors errors) {
        if (errors.hasErrors()) {
            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(massage));


        }
        employees.add(myEmployee);
        return ResponseEntity.status(200).body(new ApiResponse("Employee added"));

    }

    @PutMapping("/update/{index}")
    public ResponseEntity updateUser(@PathVariable int index, @Valid @RequestBody MyEmployee myEmployee, Errors errors) {
        if (errors.hasErrors()) {

            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(massage));
        }
        employees.set(index, myEmployee);
        return ResponseEntity.status(200).body(new ApiResponse("Employee updated"));


    }

    //by the index of the existing employee
    @PutMapping("/apply/{index}")
    public ResponseEntity applyForLeave(@PathVariable int index) {

        if (employees.get(index).isOnLeave()) {

            return ResponseEntity.status(400).body(new ApiResponse(" bad request he is on leave "));
        }
        if (employees.get(index).getAnnualLeave() == 0) {
            return ResponseEntity.status(400).body(new ApiResponse(" bad request there is no annul leave "));

        }
        employees.get(index).setOnLeave(true);
        employees.get(index).setAnnualLeave(employees.get(index).getAnnualLeave() - 1);
        return ResponseEntity.status(200).body(new ApiResponse("leave is taken"));

    }


    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteUser(@PathVariable int index) {
        employees.remove(index);
        return ResponseEntity.status(200).body(new ApiResponse("Employee deleted"));


    }


}
