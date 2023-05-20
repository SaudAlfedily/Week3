package com.example.project3.Controller;

import com.example.project3.ApiResponse.ApiResponse;
import com.example.project3.Model.MyProduct;
import com.example.project3.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/get")
    public ResponseEntity getBlog() {
        ArrayList<MyProduct> products = productService.getProducts();

        return ResponseEntity.status(200).body(products);


    }

    @PostMapping("/add")
    public ResponseEntity addProduct(@Valid @RequestBody MyProduct product, Errors errors) {

        if (errors.hasErrors()) {
            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(massage));


        }
        boolean isAdded = productService.addProduct(product);
        if (isAdded) {

            return ResponseEntity.status(200).body("Product added");


        }else return ResponseEntity.status(400).body("there  is no Category for this product");


    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@Valid @RequestBody MyProduct product,Errors errors,@PathVariable int id) {
        if (errors.hasErrors()) {

            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(massage));
        }
        int isUpdated = productService.updateProduct(id, product);

        if (isUpdated == 0) {

            return ResponseEntity.status(200).body("Product updated");


        } else if (isUpdated == -1) {
            return ResponseEntity.status(400).body("the new product category are not existing");
        }
        return ResponseEntity.status(400).body("product that you want tp update  is not here");


    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id){

        boolean isDeleted=productService.deleteProduct(id);
        if (isDeleted){
            return ResponseEntity.status(200).body("Product deleted");


        }else return ResponseEntity.status(400).body("Product is not here");


    }






}
