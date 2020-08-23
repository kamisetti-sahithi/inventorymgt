package com.dxctraining.inventorymgt.supplier.service;

import java.util.*;

import com.dxctraining.inventorymgt.supplier.entities.*;

public interface ISupplierService {

	Supplier findSupplierById(int id);

	List<Supplier> displaySuppliers();

	void remove(int id);

	Supplier addSupplier(Supplier supplier);

	Supplier updateSupplier(Supplier supplier);

}
