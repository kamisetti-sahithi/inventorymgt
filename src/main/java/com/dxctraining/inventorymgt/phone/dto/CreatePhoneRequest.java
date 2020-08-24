package com.dxctraining.inventorymgt.phone.dto;

import com.dxctraining.inventorymgt.item.entities.Item;

public class CreatePhoneRequest extends Item {
	private String name;
	private int storageSize;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStorageSize() {
		return storageSize;
	}
	public void setStoragesize(int storagesize) {
		this.storageSize = storagesize;
	}
	

}


