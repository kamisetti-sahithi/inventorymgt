package com.dxctraining.inventorymgt.phone.dao;

import com.dxctraining.inventorymgt.phone.entities.*;

public interface IPhoneDao {

    Phone add(Phone phone);

    void remove(int id);

	Phone findPhoneById(int id);
}
