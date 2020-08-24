package com.dxctraining.inventorymgt.computer.dto;

import com.dxctraining.inventorymgt.item.entities.Item;

public class CreateComputerRequest extends Item {
	private String name;
	private int disksize;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDisksize() {
		return disksize;
	}
	public void setDisksize(int disksize) {
		this.disksize = disksize;
	}

}