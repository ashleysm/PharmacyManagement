package com.cognizant.pharmacymanagement.MedicinesSupply.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.pharmacymanagement.MedicinesSupply.feingClient.StockFeignClient;
import com.cognizant.pharmacymanagement.MedicinesSupply.model.Medicine;
import com.cognizant.pharmacymanagement.MedicinesSupply.service.PharmacyMedicineSupplyService;


@RestController
public class MedicineSupplyController {
	
	@Autowired
	PharmacyMedicineSupplyService service;
	
	@Autowired
	private StockFeignClient stockFeignClient;
	
	
	@RequestMapping(value="/viewDemand", method = RequestMethod.GET)
	public ModelAndView showSupplyHomePage(){
		return new ModelAndView("viewDemand");
		
		
	}

	
	@GetMapping(value="/SupplyAvailed")
	public ModelAndView showList(@RequestParam String name, @RequestParam int demand,ModelMap model){
		
	int stock = stockFeignClient.getStockCountForMedicine(name);
		System.out.println(stock);
		service.stockDivide(demand,name,stock);
		model.put("pharmacyList", service.retrievePharmacies());
		return new ModelAndView ("SupplyAvailed");
	}
	
	
	
}
	
	