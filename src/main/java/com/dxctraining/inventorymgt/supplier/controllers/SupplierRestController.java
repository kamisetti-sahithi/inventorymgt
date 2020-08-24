package com.dxctraining.inventorymgt.supplier.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.dxctraining.inventorymgt.supplier.dto.*;
import com.dxctraining.inventorymgt.supplier.entities.*;
import com.dxctraining.inventorymgt.supplier.service.*;
@RestController
@RequestMapping("/suppliers")
public class SupplierRestController {
	@Autowired
	private ISupplierService supplierservice;
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Supplier createSupplier(@RequestBody CreateRequest supplier) {
		Supplier s1 = new Supplier(supplier.getName(), supplier.getPassword());
		s1 = supplierservice.addSupplier(s1);
		return s1;	
	}
	
	@GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Supplier getSupplier(@PathVariable("id")int id) {
		Supplier s1 = supplierservice.findSupplierById(id);
		return s1;
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Supplier updateSupplier(@RequestBody UpdateSupplierRequest supplier) {
		Supplier s1 = new Supplier(supplier.getName(),supplier.getPassword());
		s1.setId(supplier.getId());
		return supplierservice.addSupplier(s1);
	}

}
