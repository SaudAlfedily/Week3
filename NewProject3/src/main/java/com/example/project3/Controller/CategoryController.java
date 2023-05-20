package com.example.project3.Controller;

import com.example.project3.ApiResponse.ApiResponse;
import com.example.project3.Model.Category;
import com.example.project3.Model.MyUser;
import com.example.project3.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;



    @GetMapping("/get")
    public ResponseEntity get(){

        ArrayList<MyUser> users= categoryService.getCategory();
        return ResponseEntity.status(200).body(users);


    }
    @PostMapping("/add")
    public ResponseEntity addCategory(@Valid @RequestBody Category category, Errors errors){

        if (errors.hasErrors()){
            String massage=errors.getFieldError().getDefaultMessage();
            return  ResponseEntity.status(400).body(new ApiResponse(massage));



        }
        categoryService.addCategory(category);
        return ResponseEntity.status(200).body("Category added");


    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBlog(@Valid @RequestBody Category category,Errors errors,@PathVariable int id){
        if(errors.hasErrors()) {

            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(massage));
        }
        boolean isUpdated=categoryService.updateCategory(id,category);

        if (isUpdated){

            return ResponseEntity.status(200).body("Category updated");


        }else return ResponseEntity.status(400).body("Category is not here");







    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable int id){

        boolean isDeleted=categoryService.deleteCategory(id);
        if (isDeleted){
            return ResponseEntity.status(200).body("Category deleted you can't add any product to this Category");


        }else return ResponseEntity.status(400).body("Category is not here");


    }

}
