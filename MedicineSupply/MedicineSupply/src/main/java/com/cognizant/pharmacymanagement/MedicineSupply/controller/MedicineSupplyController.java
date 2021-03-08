package com.cognizant.pharmacymanagement.MedicineSupply.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.cognizant.pharmacymanagement.MedicineSupply.service.PharmacyMedicineSupplyService;


@RestController
public class MedicineSupplyController {
	@Autowired
	PharmacyMedicineSupplyService service;
	
	
	
	@RequestMapping(value="/viewDemand", method = RequestMethod.GET)
	public ModelAndView showSupplyHomePage(){
		return new ModelAndView("viewDemand");
		
		
	}

	
	@GetMapping(value="/SupplyAvailed")
	public ModelAndView showList(@RequestParam String name, @RequestParam int demand,ModelMap model){
		service.stockDivide(demand,name);
				
		model.put("pharmacyList", service.retrievePharmacies());
		return new ModelAndView ("SupplyAvailed");
	}
}
	
	