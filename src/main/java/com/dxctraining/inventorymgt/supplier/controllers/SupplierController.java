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
import com.dxctraining.inventorymgt.supplier.dto.*;

@Controller
public class SupplierController {
	@Autowired
	private ISupplierService supplierservice;
	@Autowired
	private Data sessionData;
	@PostConstruct
	public void init() {
		Supplier supplier1 = new Supplier("yasaswini","sahithi");
		int id1 = supplier1.getId();
		supplier1 = supplierservice.addSupplier(supplier1);
		
		Supplier supplier2 = new Supplier("navya","jam");
		int id2 = supplier2.getId();
		supplier2 = supplierservice.addSupplier(supplier2);
		
	}
	@GetMapping("/suppliers")
	public ModelAndView supplierDetails(@RequestParam("id")int id) {
		Supplier supplier = supplierservice.findSupplierById(id);
		ModelAndView modelAndView = new ModelAndView("supplierdetails", "supplier", supplier);
		return modelAndView;	
	}
	@GetMapping("/supplierlist")
	public ModelAndView allSuppliers() {
        List<Supplier>suppliers=supplierservice.displaySuppliers();
		ModelAndView modelAndView = new ModelAndView("list","suppliers",suppliers);
		return modelAndView;
		
		
	}
	@GetMapping("/register")
	public ModelAndView registerSupplier() {
		ModelAndView modelAndView = new ModelAndView("register");
		return modelAndView;	
	}
	
	@GetMapping("/processregister")
	public ModelAndView processRegister(@RequestParam("name")String name, @RequestParam("password")String password) {
		Supplier supplier = new Supplier(name,password);
		supplier = supplierservice.addSupplier(supplier);
		ModelAndView modelAndView = new ModelAndView("supplierdetails","supplier",supplier);
		return modelAndView;
	}
	
	@GetMapping("/postregister")
	public ModelAndView postRegister() {
		CreateRequest newSupplier = new CreateRequest();
		ModelAndView modelAndView = new ModelAndView("postregister","supplier",newSupplier);
		return modelAndView;
	}
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
	@GetMapping("/processlogin")
	public ModelAndView processLogin(@RequestParam("id")int id,@RequestParam("password")String password) {
		boolean correct = supplierservice.authentication(id,password);
		if(correct) {
			sessionData.saveLogin(id);
			Supplier supplier = supplierservice.findSupplierById(id);
			ModelAndView modelAndView = new ModelAndView("details","supplier",supplier);
			return modelAndView;
		}
			ModelAndView modelAndView = new ModelAndView("login");
			return modelAndView;
	}
	
	@GetMapping("/logout")
	public ModelAndView logout() {
		sessionData.clear();
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
	
	

}
