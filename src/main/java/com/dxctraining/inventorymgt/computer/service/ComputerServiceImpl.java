package com.dxctraining.inventorymgt.computer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.inventorymgt.computer.dao.*;
import com.dxctraining.inventorymgt.computer.entities.*;
import com.dxctraining.inventorymgt.computer.exceptions.*;
import com.dxctraining.inventorymgt.phone.entities.Phone;

@Transactional
@Service
public class ComputerServiceImpl implements IComputerService {
	
	
	@Autowired
	private IComputerDao dao;

	@Override
	public void validate(Object obj) {
		if (obj == null) {
			throw new InvalidArgumentException("Argument is null");
		}
	}

	@Override
	public Computer add(Computer computer) {
		validate(computer);
		dao.add(computer);
		return computer;
	}

	@Override
	public Computer findComputerById(int id) {
		validate(id);
		Computer computer = dao.findComputerById(id);
		return computer;
	}

	@Override
	public Computer remove(int id) {
		validate(id);
		Computer computer = dao.remove(id);
		return computer;
	}

	@Override
	public List<Computer> listAll() {
		List<Computer>computers=dao.listAll();
        return computers ;
	}
	
	



}