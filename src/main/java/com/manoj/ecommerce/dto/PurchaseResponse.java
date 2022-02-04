package com.manoj.ecommerce.dto;

import lombok.Data;

@Data
public class PurchaseResponse {

	private  String orderTrackingNumber = null;

    public PurchaseResponse(String orderTrackingNumber) {
		super();
		this.orderTrackingNumber = orderTrackingNumber;
	}

    
    

}
