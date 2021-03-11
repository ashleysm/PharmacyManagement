package com.cognizant.pharmacymanagement.MedicinesSupply.controller;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.pharmacymanagement.MedicinesSupply.feingClient.StockFeignClient;
import com.cognizant.pharmacymanagement.MedicinesSupply.model.Medicine;
import com.cognizant.pharmacymanagement.MedicinesSupply.service.PharmacyMedicineSupplyService;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest

public class MedicineSupplyControllerTest {
	
	@InjectMocks
	private MedicineSupplyController medicineSupplyController;
	
	@Mock
	private StockFeignClient stockClient;
	
	@Mock
	private PharmacyMedicineSupplyService pharmacyService;
	private String testString;
	private int testDemand;
	
	@BeforeEach
	public void setup() {
		testString = "Orthoherb";
		testDemand = 500;
	} 
	
	
	@Test
	public void testShowList() throws Exception{
	ResponseEntity<?> responseEntity = medicineSupplyController.showList(testString, testDemand);
	stockClient.getStockCountForMedicine(testString);
	HttpStatus status = responseEntity.getStatusCode();
	assertNotNull(status);
	assertEquals(HttpStatus.OK,status);
	
	}
}
