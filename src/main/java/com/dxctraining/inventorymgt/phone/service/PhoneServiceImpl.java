package com.dxctraining.inventorymgt.phone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.inventorymgt.phone.dao.IPhoneDao;
import com.dxctraining.inventorymgt.phone.entities.Phone;
import com.dxctraining.inventorymgt.phone.exceptions.InvalidArgumentException;

@Transactional
@Service
public class PhoneServiceImpl implements IPhoneService{

    @Autowired
    private IPhoneDao dao;

    @Override
    public Phone findPhoneById(int id) {
    	Phone phone= dao.findPhoneById(id);
        return phone;
    }


    @Override
    public Phone add(Phone phone) {
	display(phone);
	phone=dao.add(phone);
        return phone;
    }

    public void display(Object arg) {
	if (arg == null) {
		throw new InvalidArgumentException("argument is null");
		}
	}

    @Override
    public void remove(int id) {
       dao.remove(id);
    }


	@Override
	public List<Phone> listAll() {
		 List<Phone>phones=dao.listAll();
	        return phones;
	}

  
}
