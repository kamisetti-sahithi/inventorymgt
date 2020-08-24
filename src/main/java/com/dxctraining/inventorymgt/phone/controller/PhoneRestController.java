package com.dxctraining.inventorymgt.phone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.dxctraining.inventorymgt.phone.dto.*;
import com.dxctraining.inventorymgt.phone.entities.*;
import com.dxctraining.inventorymgt.phone.service.*;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;
import com.dxctraining.inventorymgt.supplier.*;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
@RestController
@RequestMapping("/phones")
public class PhoneRestController {
	
	@Autowired
	private IPhoneService phnservice;
	 @Autowired
	 private ISupplierService supplierservice;
	 @PostMapping("/add")
	 @ResponseStatus(HttpStatus.CREATED)
	    public Phone create(@RequestBody CreatePhoneRequest requestdata) {
	        String name = requestdata.getName();
	        Supplier supplier=requestdata.getSupplier();
	        int storageSize=requestdata.getStorageSize();
	      Phone phone= new Phone(name,supplier,storageSize);
	        phone = phnservice.add(phone);
	        return phone;
	    }
	 @GetMapping("/get/{id}")
	 @ResponseStatus(HttpStatus.FOUND)
	    public Phone findPhone(@PathVariable("id") int id) {
	        Phone phone = phnservice.findPhoneById(id);
	        return phone;
	    }
	
}
