package com.example.project3.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {
    @NotNull(message = "MerchantStock id should not be null")
    @Min(value = 100, message = "need to 3 digit")
    @Max(value = 999, message = "need to 3 digit")
    private int id;

    @NotNull(message = "productId id should not be null")
    @Min(value = 100, message = "need to 3 digit")
    @Max(value = 999, message = "need to 3 digit")
    private int productid;

    @NotNull(message = "Merchant id should not be null")
    @Min(value = 100, message = "need to 3 digit")
    @Max(value = 999, message = "need to 3 digit")
    private int merchantid;

    @NotNull
    @Min(value = 11,message = "stock need to be more than 10")
    private int stock;


}
