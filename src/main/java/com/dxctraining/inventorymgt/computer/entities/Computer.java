package com.dxctraining.inventorymgt.computer.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;

@Entity
@Table(name="computer")
public class Computer extends Item {

	private int diskSize;
	
	
	public Computer( String name, Supplier supplier,int disksize) {
		super(name,supplier);
		this.diskSize=disksize;
	}
	
	public Computer() {
		
	}

	public int getDisksize() {
		return diskSize;
	}

	public void setDisksize(int disksize) {
		this.diskSize = disksize;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Computer that = (Computer) o;
		return diskSize == that.diskSize;
	}

	@Override
	public int hashCode() {
		return diskSize;
	}

}
