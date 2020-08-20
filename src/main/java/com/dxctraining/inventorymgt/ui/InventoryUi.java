package com.dxctraining.inventorymgt.ui;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dxctraining.inventorymgt.computer.entities.Computer;
import com.dxctraining.inventorymgt.computer.exceptions.ComputerNotFoundException;
import com.dxctraining.inventorymgt.computer.exceptions.InvalidArgumentException;
import com.dxctraining.inventorymgt.computer.service.IComputerService;
import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.item.exceptions.ItemNotFoundException;
import com.dxctraining.inventorymgt.item.service.IItemService;
import com.dxctraining.inventorymgt.phone.entities.Phone;
import com.dxctraining.inventorymgt.phone.exceptions.PhoneNotFoundException;
import com.dxctraining.inventorymgt.phone.service.IPhoneService;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.exceptions.SupplierNotFoundException;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

@Component
public class InventoryUi {

	@Autowired
	private ISupplierService supplierservice;

	@Autowired

	private IItemService itemservice;

	@Autowired
	private IPhoneService phoneservice;

	@Autowired
	private IComputerService computerService;

	@PostConstruct
	public void runApp() {
		try {
			Supplier supplier1 = new Supplier("yasaswini");
			Supplier supplier2 = new Supplier("navya");
			supplierservice.addSupplier(supplier1);
			supplierservice.addSupplier(supplier2);

			int id1 = supplier1.getId();
			Supplier sup1 = supplierservice.findSupplierById(id1);
			System.out.println(sup1.getId() + "  " + sup1.getName());

			Item item1 = new Item("pendrive", supplier1);
			item1 = itemservice.addItem(item1);
			Item item2 = new Item("usb", supplier2);
			item2 = itemservice.addItem(item2);

			System.out.println(item1.getName() + " " + item1.getId());

			Phone ph1 = new Phone("realme", supplier1, 1000);
			phoneservice.add(ph1);
			Phone ph2 = new Phone("mi", supplier2, 2000);
			phoneservice.add(ph2);

			System.out.println(ph1.getName() + " " + ph1.getStoragesize());

			Computer computer1 = new Computer("dell", supplier1, 10);
			computerService.add(computer1);

			Computer computer2 = new Computer("hp", supplier2, 20);
			computerService.add(computer2);

			System.out.println(computer1.getName() + " " + computer1.getDisksize());

		}

		catch (InvalidArgumentException e) {
			e.printStackTrace();
		} catch (SupplierNotFoundException e) {
			e.printStackTrace();

		} catch (ItemNotFoundException e) {
			e.printStackTrace();

		} catch (ComputerNotFoundException e) {
			e.printStackTrace();
		} catch (PhoneNotFoundException e) {
			e.printStackTrace();
		}

	}

}