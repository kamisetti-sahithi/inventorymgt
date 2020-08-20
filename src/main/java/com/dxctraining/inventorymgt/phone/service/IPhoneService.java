package com.dxctraining.inventorymgt.phone.service;
import com.dxctraining.inventorymgt.phone.entities.Phone;

public interface IPhoneService {
	Phone findPhoneById(int id);

    void remove(int id);

	Phone add(Phone phone);
}
