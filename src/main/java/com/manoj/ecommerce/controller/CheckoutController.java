package com.manoj.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manoj.ecommerce.dto.Purchase;
import com.manoj.ecommerce.dto.PurchaseResponse;
import com.manoj.ecommerce.service.CheckoutService;

//@CrossOrigin("http://localhost:4200") -> uncomment this if not work latest changes
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

	@Autowired
	private CheckoutService checkoutService;

	public CheckoutController(CheckoutService checkoutService) {
		this.checkoutService = checkoutService;
	}

	@PostMapping(value ="/purchase",  produces = "application/json;charset=UTF-8")
	public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
		PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
		return purchaseResponse;
	}
}
