package com.dxctraining.inventorymgt.supplier.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dxctraining.inventorymgt.supplier.entities.*;
import com.dxctraining.inventorymgt.supplier.exceptions.*;

import java.util.*;


@Repository
public  class SupplierDaoImpl implements ISupplierDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	 @Override
	    public Supplier findSupplierById(int id) {
	       Supplier supplier=entityManager.find(Supplier.class,id);
	        if(supplier==null){
	            throw new SupplierNotFoundException("supplier not found for id="+id);
	        }
	        return supplier;
	
	

}
	
	 @Override
		public List<Supplier> displaySuppliers() {
		        String jpaql="from supplier";
		        TypedQuery<Supplier>query=entityManager.createQuery(jpaql,Supplier.class);
		        List<Supplier>supplierlist=query.getResultList();
		        return supplierlist;
		}
	 @Override
	    public void remove(int id) {
	     Supplier supplier= entityManager.find(Supplier.class,id) ;
	     entityManager.remove(supplier);
	    }
	 
	 @Override
		public Supplier addSupplier(Supplier supplier) {
			entityManager.persist(supplier);
			return supplier;
			
		}

	@Override
	public Supplier updateSupplier(Supplier supplier) {
		entityManager.merge(supplier);
		return supplier;
	}
	
	 
}