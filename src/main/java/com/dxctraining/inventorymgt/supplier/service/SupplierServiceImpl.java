package com.dxctraining.inventorymgt.supplier.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.inventorymgt.supplier.dao.*;
import com.dxctraining.inventorymgt.supplier.entities.*;
import com.dxctraining.inventorymgt.supplier.exceptions.*;

import java.util.*;

@Transactional
@Service
public class SupplierServiceImpl implements ISupplierService {

	@Autowired
	private ISupplierDao dao;

	@Override
	public Supplier findSupplierById(int id) {
		Supplier supplier = dao.findSupplierById(id);
		return supplier;
	}

	@Override
	public Supplier addSupplier(Supplier supplier) {
		validateSupplier(supplier);
		supplier = dao.addSupplier(supplier);
		return supplier;

	}

	public void validateSupplier(Supplier supplier) {
		if (supplier == null) {
			throw new SupplierNotFoundException("supplier not found");
		}

	}

	@Override
	public void remove(int id) {
		dao.remove(id);
	}

	@Override
	public List<Supplier> displaySuppliers() {
		List<Supplier> suppliers = dao.displaySuppliers();
		return suppliers;
	}

	@Override
	public Supplier updateSupplier(Supplier supplier) {
		validateSupplier(supplier);
		dao.updateSupplier(supplier);
		return supplier;
	}

	@Override
	public boolean authentication(int id, String password) {
		Supplier supplier = dao.findSupplierById(id);
		String fetchpassword = supplier.getPassword();
		boolean equals = fetchpassword.equals(password);
		return equals;
	}
}
