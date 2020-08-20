package com.dxctraining.inventorymgt.computer.dao;

import com.dxctraining.inventorymgt.computer.entities.*;

public interface IComputerDao  {
	
	Computer add(Computer computer);

	Computer findComputerById(int id);

	Computer remove(int id);
}
	

	

