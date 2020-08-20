package com.dxctraining.inventorymgt.supplier.dao;

import java.util.*;

import com.dxctraining.inventorymgt.supplier.entities.*;

public interface ISupplierDao {

	Supplier findSupplierById(int id);
	
	List<Supplier>displaySuppliers();

	void remove(int id);

	Supplier addSupplier(Supplier supplier);

}
