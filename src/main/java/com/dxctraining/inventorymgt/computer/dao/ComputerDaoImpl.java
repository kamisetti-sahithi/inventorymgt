package com.dxctraining.inventorymgt.computer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dxctraining.inventorymgt.computer.entities.*;
import com.dxctraining.inventorymgt.computer.exceptions.*;
import com.dxctraining.inventorymgt.phone.entities.Phone;

@Repository
public class ComputerDaoImpl implements IComputerDao {
	
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Computer add(Computer computer) {
		entityManager.persist(computer);
		return computer;
	}
	
	@Override
	public Computer findComputerById(int id) {
		Computer computer = entityManager.find(Computer.class, id);
		if (computer == null) {
			throw new ComputerNotFoundException("Computer not found");
		}
		return computer;
	}

	@Override
	public Computer remove(int id) {
		Computer computer = findComputerById(id);
		entityManager.remove(computer);
		return computer;
		
	}

	@Override
	public List<Computer> listAll() {
		String jpaql="from computers";
        TypedQuery<Computer>query=entityManager.createQuery(jpaql,Computer.class);
        List<Computer>computerlist=query.getResultList();
        return computerlist;
		
	}
	
	

	

}
