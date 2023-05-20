package com.example.project3.Service;

import com.example.project3.Model.MerchantStock;
import com.example.project3.Model.MyProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Data
@AllArgsConstructor
@Service
public class MerchantStockService {

    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();
    private final MerchantService merchantService;
    private final ProductService productService;

    public ArrayList<MerchantStock> getStock() {
        return merchantStocks;
    }

    public int addStock(MerchantStock merchantStock) {
        for (int i = 0; i < merchantService.merchants.size(); i++) {
            if (merchantStock.getMerchantid() == merchantService.merchants.get(i).getId()) {


                for (int j = 0; j < productService.products.size(); j++) {

                    if (merchantStock.getProductid() == productService.products.get(i).getId()) {


                        merchantStocks.add(merchantStock);
                        merchantStock.setStock(merchantStock.getStock());
                        return 0;


                    }


                }
                return 1; //product id wrong


            }
        }
        return -1;//merchent id wrong ;
    }


    public int updateStock(int id, MerchantStock merchantStock) {


        for (int l = 0; l < productService.products.size(); l++) {
            if (merchantStock.getProductid() == productService.products.get(l).getId()) {


                for (int i = 0; i < merchantService.merchants.size(); i++) {
                    if (merchantStock.getMerchantid() == merchantService.merchants.get(i).getId()) {


                        for (int j = 0; j < merchantStocks.size(); j++) {

                            if (merchantStocks.get(j).getId() == id) {


                                merchantStocks.set(j, merchantStock);
                                return 0; //right


                            }
                        }
                        return 1;


                    }
                }
                return -1;//wrong merchent id

            }
        }
        return -2;  //product id wrong
    }
    public boolean deleteStock(int id) {

        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId() == id) {

                merchantStocks.remove(i);
                return true;
            }


        }
        return false;


    }




    public int addToStock(int productid, int merchantid , int stock){
        for (int i=0;i<merchantService.merchants.size();i++){
            if (merchantService.merchants.get(i).getId()==merchantid){

                for (int j=0;j<merchantStocks.size();j++){
                    if (merchantStocks.get(j).getMerchantid()==merchantid && merchantStocks.get(j).getProductid()==productid){


                        if (stock>=0){

                           merchantStocks.get(j).setStock( merchantStocks.get(j).getStock()+stock);

                            return 0;//stock added
                        }return -5; //don't add nigative number to stock

                    }





                }return -2;//merchant dose not have this product



            }

        }return -1; // merchant not found



    }














}
