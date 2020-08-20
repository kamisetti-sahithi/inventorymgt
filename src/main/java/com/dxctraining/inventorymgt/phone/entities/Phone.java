package com.dxctraining.inventorymgt.phone.entities;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.dxctraining.inventorymgt.item.entities.*;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;

@Entity
@Table(name="phone")
public class Phone extends Item {
	
private int storageSize;

public Phone(String name, Supplier supplier, int storagesize) {
	super(name,supplier);
	this.storageSize=storagesize;
}

public Phone() {
	
}

public int getStoragesize() {
	return storageSize;
}

public void setStoragesize(int storagesize) {
	this.storageSize = storagesize;
}
public int hashCode()
{
	return storageSize; 
}
public boolean equals(Object arg) {
	if(this==arg) {
		return true;
	}
	
   if(arg==null || !(arg instanceof Phone) ) {
		return false;
   }
	
    Phone that=(Phone)arg;	
	boolean isequal=this.getId()==that.getId();
	return isequal;
}		


}
