package com.example.project3.Controller;

import com.example.project3.ApiResponse.ApiResponse;
import com.example.project3.Model.MerchantStock;
import com.example.project3.Model.MyProduct;
import com.example.project3.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/stock")
@RequiredArgsConstructor
public class MerchantStockController {

    private final MerchantStockService merchantStockService;

    @GetMapping("/get")
    public ResponseEntity getStock() {
        ArrayList<MerchantStock> merchantStocks = merchantStockService.getStock();

        return ResponseEntity.status(200).body(merchantStocks);


    }



    @PostMapping("/add")
    public ResponseEntity addStock(@Valid @RequestBody MerchantStock merchantStock, Errors errors) {

        if (errors.hasErrors()) {
            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(massage));


        }
        int isAdded = merchantStockService.addStock(merchantStock);

        if (isAdded==0){



          return ResponseEntity.status(200).body("merchantStock added");

        } else if (isAdded==1) {
            return ResponseEntity.status(400).body("product id is not exiting");

        }return ResponseEntity.status(400).body(" merchant id is not existing");
    }


    @PostMapping("/addstock/{productid}/{merchantid}/{stock}")
    public ResponseEntity addToStock(@PathVariable int productid, @PathVariable int merchantid, @Valid @PathVariable int stock) {
//
//        if (errors.hasErrors()) {
//            String massage = errors.getFieldError().getDefaultMessage();
//            return ResponseEntity.status(400).body(new ApiResponse(massage));
//
//
//        }
        int added = merchantStockService.addToStock(productid, merchantid, stock);
        if (added == 0) {
            return ResponseEntity.status(200).body("it's added");
        } else if (added == -1) {
            return ResponseEntity.status(400).body("merchant not found");
        } else if (added==-5) {
            return ResponseEntity.status(400).body(" don't add negative number to stock");
        } else return ResponseEntity.status(400).body("merchant dose not have the product");


    }




    @PutMapping("/update/{id}")
    public ResponseEntity updateStock(@Valid @RequestBody MerchantStock merchantStock,Errors errors,@PathVariable int id) {
        if (errors.hasErrors()) {

            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(massage));
        }
        int isUpdated = merchantStockService.updateStock(id, merchantStock);

        if (isUpdated == 0) {

            return ResponseEntity.status(200).body("merchantStock updated");


        } else if (isUpdated == -1) {
            return ResponseEntity.status(400).body("merchant id is not in the system");
        }
        else if (isUpdated == -2) {
            return ResponseEntity.status(400).body("product id is not in the system");
        }
        return ResponseEntity.status(400).body("product that you want tp update  is not here");


    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStock(@PathVariable int id){

        boolean isDeleted=merchantStockService.deleteStock(id);
        if (isDeleted){
            return ResponseEntity.status(200).body("merchantStock deleted");


        }else return ResponseEntity.status(400).body("merchantStock is not here");


    }








}
