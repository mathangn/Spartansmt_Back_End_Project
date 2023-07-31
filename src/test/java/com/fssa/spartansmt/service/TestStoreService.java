package com.fssa.spartansmt.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.spartansmt.dao.DAOException;
import com.fssa.spartansmt.model.Store;

public class TestStoreService {


	@Test
	public void testValidateAddStore() throws DAOException {
		
		Store s1 = new Store("Poorvika", "Mobile Shop", "https://iili.io/HWXknrg.png");
		StoreService ss = new StoreService();
		Assertions.assertTrue(ss.addStore(s1));
		
	}
	
	@Test 
	public void testValidateUpdateStore() throws IllegalArgumentException, DAOException {
		Store s1 = new Store();
		s1.setId(12);
		s1.setName("MAC");
		s1.setCategory("Beauty Products");
		s1.setStoreLogoLink("https://iili.io/HWXk2mQ.gif");
		
		Assertions.assertTrue(StoreService.updateStore(s1));
	}
	
	@Test
	public void testValidateDeleteStore() throws IllegalAccessException, DAOException {
		Store s2 = new Store();
		s2.setId(13);
		Assertions.assertTrue(StoreService.deleteStore(s2.getId()));
	}
	
	@Test
	public void testValidateGetAllStoreDetails() throws DAOException {
		Assertions.assertTrue(StoreService.getAllStoreDetails());
	}

	
}
