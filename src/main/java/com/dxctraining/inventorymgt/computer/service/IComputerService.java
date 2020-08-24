package com.dxctraining.inventorymgt.computer.service;

import java.util.List;

import com.dxctraining.inventorymgt.computer.entities.*;

public interface IComputerService {
	
    void validate(Object obj);
	
	Computer add(Computer computer);

	Computer findComputerById(int id);

	Computer remove(int id);

	List<Computer> listAll();

	


	

}
