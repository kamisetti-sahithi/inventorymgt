package com.dxctraining.inventorymgt.phone.controller;
import com.dxctraining.inventorymgt.phone.dto.CreatePhoneRequest;
import com.dxctraining.inventorymgt.phone.entities.*;
import com.dxctraining.inventorymgt.phone.service.IPhoneService;
import com.dxctraining.inventorymgt.supplier.dto.Data;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

import java.util.*;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PhoneController {
	@Autowired
	private ISupplierService supplierservice;
	@Autowired
	private IPhoneService phnservice;
	@Autowired
	private Data sessionData;
	
	
	@PostConstruct
	public void run() {
		Supplier supplier1=new Supplier("yasaswini","sahithi");
		Supplier supplier2=new Supplier("navya","jam");
		Phone phone1=new Phone("realme", supplier1, 1000);
		phnservice.add(phone1);
		Phone phone2=new Phone("mi", supplier2, 2000);
		phnservice.add(phone2);
		System.out.println(phone1.getName()+" "+phone1.getSupplier()+" "+phone1.getStoragesize());
		
		
	}
	@GetMapping("/phones")
	public ModelAndView phoneDetails(@RequestParam("id")int id) {
		Phone phone = phnservice.findPhoneById(id);
		ModelAndView modelAndView = new ModelAndView("phone details", "phone",phone);
		return modelAndView;
	}
	@GetMapping("/phonelists")
	public ModelAndView allPhones() {
        List<Phone>listall=phnservice.listAll();
		ModelAndView modelAndView = new ModelAndView("phonelist","phone",listall);
		return modelAndView;
		
		
	}
	@GetMapping("/addphone")
	public ModelAndView addPhone() {
		ModelAndView modelAndView = new ModelAndView("addphone");
		return modelAndView;
	}
	@GetMapping("/processaddphone")
	public ModelAndView processAddPhone(@RequestParam("name")String name, @RequestParam("storageSize")int storageSize) {
		Phone phone = new Phone();
		ModelAndView modelAndView = new ModelAndView("processaddphone","phone",phone);
		return modelAndView;
	}
	
	@GetMapping("/postaddphone")
	public ModelAndView postAddPhone() {
		CreatePhoneRequest phone = new CreatePhoneRequest();
		ModelAndView modelAndView = new ModelAndView("postaddphone","phone",phone);
		return modelAndView;
	}

	
	
	

}
