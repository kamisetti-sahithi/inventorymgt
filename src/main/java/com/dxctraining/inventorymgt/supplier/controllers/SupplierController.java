package com.dxctraining.inventorymgt.supplier.controllers;
import com.dxctraining.inventorymgt.supplier.entities.*;
import com.dxctraining.inventorymgt.supplier.service.*;
import java.util.*;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SupplierController {
	@Autowired
	private ISupplierService supplierservice;
	@PostConstruct
	public void init() {
		Supplier supplier1 = new Supplier("yasaswini");
		int id1 = supplier1.getId();
		supplier1 = supplierservice.addSupplier(supplier1);
		
		Supplier supplier2 = new Supplier("navya");
		int id2 = supplier2.getId();
		supplier2 = supplierservice.addSupplier(supplier2);
		
	}
	@GetMapping("/supplier")
	public ModelAndView supplierDetails(@RequestParam("id")int id) {
		Supplier supplier = supplierservice.findSupplierById(id);
		ModelAndView modelAndView = new ModelAndView("details", "supplier", supplier);
		return modelAndView;	
	}
	@GetMapping("/supplierlist")
	public ModelAndView allSuppliers() {
        List<Supplier>suppliers=supplierservice.displaySuppliers();
		ModelAndView modelAndView = new ModelAndView("list","suppliers",suppliers);
		return modelAndView;
		
		
	}
	
	

}
