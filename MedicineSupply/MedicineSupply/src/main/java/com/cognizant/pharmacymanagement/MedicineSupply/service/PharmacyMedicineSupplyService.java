package com.cognizant.pharmacymanagement.MedicineSupply.service;
import java.util.*;

import org.springframework.stereotype.Service;

import com.cognizant.pharmacymanagement.MedicineSupply.model.*;



@Service
public class PharmacyMedicineSupplyService {
	private static int supply=0;
	private static String medName;
	PharmacyList ph;
	
	private static List<PharmacyMedicineSupply> pharmacyList = new ArrayList<PharmacyMedicineSupply>();
    


    public List<PharmacyMedicineSupply> retrievePharmacies() {
    	
        return pharmacyList;
    }
    
    public void stockDivide(int demand,String medicine) {
    	int stock = 2000;
    	
    	if (demand>stock) {
    		supply=0;
    	}
    	supply=demand/5;
    	medName = medicine;
    	pharmacyList.add(new PharmacyMedicineSupply("MedCity",medName,supply));
    	pharmacyList.add(new PharmacyMedicineSupply("Med 7",retrieveMedName(),retrieveStock()));
    	pharmacyList.add(new PharmacyMedicineSupply("PharmaOne",retrieveMedName(),retrieveStock()));
    	pharmacyList.add(new PharmacyMedicineSupply("MediLane",retrieveMedName(),retrieveStock()));
    	pharmacyList.add(new PharmacyMedicineSupply("Pharma Plus",retrieveMedName(),retrieveStock()));
    }
    public static int retrieveStock() {
    	return supply;
    }
    
    public static String retrieveMedName() {
    	return medName;
    }
    
   
}

