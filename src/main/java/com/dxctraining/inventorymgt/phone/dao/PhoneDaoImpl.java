package com.dxctraining.inventorymgt.phone.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dxctraining.inventorymgt.phone.entities.Phone;
import com.dxctraining.inventorymgt.phone.exceptions.PhoneNotFoundException;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
@Repository
public class PhoneDaoImpl implements IPhoneDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Phone add(Phone phone) {
		entityManager.persist(phone);
		return phone;
	}

	@Override
	public Phone findPhoneById(int id) {
		Phone phone = entityManager.find(Phone.class, id);
		if (phone == null) {
			throw new PhoneNotFoundException("Phone not found");
		}
		return phone;
	}

	@Override
	public void remove(int id) {
		Phone phone = findPhoneById(id);
		entityManager.remove(phone);
		
	}

	@Override
	public List<Phone> listAll() {
		String jpaql="from phones";
        TypedQuery<Phone>query=entityManager.createQuery(jpaql,Phone.class);
        List<Phone>phonelist=query.getResultList();
        return phonelist;
	}

	
}
