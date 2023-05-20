package com.example.project3.Service;

import com.example.project3.Model.Category;
import com.example.project3.Model.MyProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Data
@AllArgsConstructor
@Service
public class ProductService {

    ArrayList<MyProduct> products = new ArrayList<>();
    private final CategoryService categoryService;

    public ArrayList<MyProduct> getProducts() {
        return products;
    }

    public boolean addProduct(MyProduct product) {
        for (int i = 0; i < categoryService.categories.size(); i++) {
            if (product.getCategoryID() == categoryService.categories.get(i).getId()) {
                products.add(product);
                return true;

            }
        }
        return false;
    }


    public int updateProduct(int id, MyProduct product) {


        for (int i = 0; i < categoryService.categories.size(); i++) {
            if (product.getCategoryID() == categoryService.categories.get(i).getId()) {


                for (int j = 0; j < products.size(); j++) {

                    if (products.get(j).getId() == id) {
                        products.set(j, product);
                        return 0;

                    }
                }
                return 1;


            }
        }
        return -1;


    }

    public boolean deleteProduct(int id) {

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {

products.remove(i);
                return true;
            }


        }
        return false;


    }


}

