package com.example.project3.Controller;

import com.example.project3.ApiResponse.ApiResponse;
import com.example.project3.Model.MerchantStock;
import com.example.project3.Model.MyProduct;
import com.example.project3.Model.MyUser;
import com.example.project3.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

private final UserService userService;



@GetMapping("/get")
    public ResponseEntity getUser(){

       ArrayList<MyUser>users= userService.getUsers();
        return ResponseEntity.status(200).body(users);


    }
    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody MyUser user, Errors errors){

        if (errors.hasErrors()){
            String massage=errors.getFieldError().getDefaultMessage();
            return  ResponseEntity.status(400).body(new ApiResponse(massage));



        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("user added");


    }


    @PutMapping("/buy/{userid}/{productid}/{merchantid}")
public ResponseEntity buy(@PathVariable int userid, @PathVariable int productid ,@PathVariable int merchantid){

int completed=userService.buy(userid,productid,merchantid);

if (completed==0){
    return ResponseEntity.status(200).body("the buy is completed ");



} else if (completed==-1) {
    return ResponseEntity.status(400).body("user id not found ");
} else if (completed==-2) {
    return ResponseEntity.status(400).body("merchant id not found ");
} else if (completed==-3) {
    return ResponseEntity.status(400).body("product id not found ");
} else if (completed==-4) {
    return ResponseEntity.status(400).body("merchant dose not have the product in stock ");
} else if (completed==-5) {
    return ResponseEntity.status(400).body("balance not enough or the product is out of stuck");
}
return  ResponseEntity.status(400).body("something went wrong");

    }


    @PostMapping("/addstock/{productid}/{merchantid}")
    public ResponseEntity addToStock(@PathVariable int productid, @PathVariable int merchantid, @Valid @RequestBody MerchantStock stock, Errors errors) {

        if (errors.hasErrors()) {
            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(massage));


        }
        int added = userService.addToStock(productid, merchantid, stock);
        if (added == 0) {
            return ResponseEntity.status(200).body("it's added");
        } else if (added == -1) {
            return ResponseEntity.status(400).body("merchant not found");
        } else return ResponseEntity.status(400).body("merchant dose not have the product");


    }








    @PutMapping("/update/{id}")
    public ResponseEntity updateBlog(@Valid @RequestBody MyUser user,Errors errors,@PathVariable int id){
        if(errors.hasErrors()) {

            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(massage));
        }
        boolean isUpdated=userService.updateUser(id,user);

        if (isUpdated){

            return ResponseEntity.status(200).body("User updated");


        }else return ResponseEntity.status(400).body("User is not here");







    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable int id){

        boolean isDeleted=userService.deleteUser(id);
        if (isDeleted){
            return ResponseEntity.status(200).body("User deleted");


        }else return ResponseEntity.status(400).body("User is not here");


    }



}
