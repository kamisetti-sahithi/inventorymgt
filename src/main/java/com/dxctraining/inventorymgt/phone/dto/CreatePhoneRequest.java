package com.dxctraining.inventorymgt.phone.dto;

public class CreatePhoneRequest {
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


