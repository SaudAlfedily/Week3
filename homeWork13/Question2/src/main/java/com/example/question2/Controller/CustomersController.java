package com.example.question2.Controller;

import com.example.question2.Model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/customer")
public class CustomersController {


    ArrayList<Customer> customers=new ArrayList<>();
    @GetMapping("/get-customer")
    public ArrayList getCustomer(){
        return customers;
}

    @PostMapping("/add")
    public String addCustomer(@RequestBody Customer customer){
        customers.add(customer);
        return "customer added";

    }

    @PutMapping("/update-customer/{index}")
    public String updateCustomer(@PathVariable int index ,@RequestBody Customer customer){
        customers.set(index,customer);

        return "Customer updated";

    }

    @DeleteMapping("/delete-customer/{index}")
    public String deleteCustomer(@PathVariable int index){

        customers.remove(index);
        return "customer deleted";
    }

//I assume that the index and the money we want to deposit sent in the path of the url
@PutMapping("/deposit/{indix}/{deposit}")
    public String deposit(@PathVariable int indix ,@PathVariable double deposit){



if(deposit<=0){
    return "please enter right amount";

}else
    try {  customers.get(indix).setBalance(customers.get(indix).getBalance()+deposit);
return "deposit has been send "+customers.get(indix).toString();
    }catch(IndexOutOfBoundsException e1){
        return "please enter right index";
    }}


    //I assume that the index and the money we want to withdraw sent in the path of the url

    @PutMapping("/withdraw/{index}/{withdraw}")
public String withDraw(@PathVariable int index,@PathVariable double withdraw){

      try{  if (withdraw>customers.get(index).getBalance()){

            return "the withdraw is greater the existing balance";

        } else if (withdraw<0) {
            return "please enter right amount";

        } else  customers.get(index).setBalance(customers.get(index).getBalance()-withdraw);
        return "withdraw has been done "+ customers.get(index).toString();}catch (IndexOutOfBoundsException e2){
          return "please enter right index";
      }


}












}
