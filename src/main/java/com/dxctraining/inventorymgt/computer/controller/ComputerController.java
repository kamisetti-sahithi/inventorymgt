package com.dxctraining.inventorymgt.computer.controller;

import com.dxctraining.inventorymgt.computer.entities.*;
import com.dxctraining.inventorymgt.computer.service.*;
import com.dxctraining.inventorymgt.phone.entities.Phone;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class ComputerController {
	@Autowired
	private ISupplierService supplierservice;
	@Autowired
	private IComputerService computerservice;

	@PostConstruct
	public void run() {
		Supplier supplier1 = new Supplier("yasaswini");
		Supplier supplier2 = new Supplier("navya");
		Computer computer1 = new Computer("dell", supplier1, 10);
		computerservice.add(computer1);

		Computer computer2 = new Computer("hp", supplier2, 20);
		computerservice.add(computer2);
		System.out.println(computer1.getName()+" "+computer1.getDisksize());
		
		
	}
	@GetMapping("/computers")
	public ModelAndView computerDetails(@RequestParam("id")int id) {
		Computer computer= computerservice.findComputerById(id);
		ModelAndView modelAndView = new ModelAndView("details", "computer",computer);
		return modelAndView;
	}
	@GetMapping("/computerlists")
	public ModelAndView allPhones() {
        List<Computer>listall=computerservice.listAll();
		ModelAndView modelAndView = new ModelAndView("computerlist","computer",listall);
		return modelAndView;
		
		
	}
	

}
