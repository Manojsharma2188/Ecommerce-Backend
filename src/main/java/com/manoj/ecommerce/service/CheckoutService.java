package com.manoj.ecommerce.service;

import com.manoj.ecommerce.dto.Purchase;
import com.manoj.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {
	
    PurchaseResponse placeOrder(Purchase purchase);

}
