package com.dxctraining.inventorymgt.computer.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.dxctraining.inventorymgt.supplier.entities.*;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;
import com.dxctraining.inventorymgt.computer.dto.*;
import com.dxctraining.inventorymgt.computer.entities.*;
import com.dxctraining.inventorymgt.computer.service.*;
@RestController
@RequestMapping("/computers")

public class ComputerRestController {
	 @Autowired
		private IComputerService computerservice;
		 @Autowired
		 private ISupplierService supplierservice;
		 @PostMapping("/add")
		 @ResponseStatus(HttpStatus.CREATED)
		    public Computer create(@RequestBody CreateComputerRequest requestdata) {
		        String name = requestdata.getName();
		        Supplier supplier=requestdata.getSupplier();
		        int diskSize=requestdata.getDisksize();
		      Computer computer = new Computer(name,supplier,diskSize);
		        computer = computerservice.add(computer);
		        return computer;
		    }
		 @GetMapping("/get/{id}")
		 @ResponseStatus(HttpStatus.FOUND)
		    public Computer findComputer(@PathVariable("id") int id) {
		        Computer computer = computerservice.findComputerById(id);
		        return computer;
		    }

}
