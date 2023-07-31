package com.fssa.spartansmt.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.spartansmt.model.Store;
import com.fssa.spartansmt.validator.StoreValidatorErrors;

public class TestStoreDao {
	
	public Store storeDetails() {
		
		Store s = new Store();
		s.setId(14);
		s.setName("Vero Moda");
		s.setCategory("Fashion Dress For Women");
		s.setStoreLogoLink("https://iili.io/HWXeyru.png");
		return s;
		
	}
	
	@Test
	public void testValidateAddStore() throws DAOException {
		Assertions.assertTrue(StoreDao.addStore(storeDetails()));
	}
	
	@Test
	public void testValidateUpdateStore() throws DAOException {
		Assertions.assertTrue(StoreDao.updateStore(storeDetails()));
	}
	
	@Test
	public void testValidateDeleteStore() throws IllegalAccessException, DAOException {
		Assertions.assertTrue(StoreDao.deleteStore(14));
	}
	
	@Test
	public void testValidateGetAllStoreDetails() throws DAOException {
		Assertions.assertTrue(StoreDao.getAllStoreDetails());
	}

	@Test 
	public void testInvalidUpdateStoreId() throws DAOException {
		
		Store sl = new Store();
		sl.setId(0);
		sl.setName("Vero Moda");
		sl.setCategory("Fashion Dress For Women");
		sl.setStoreLogoLink("https://iili.io/HWXeyru.png");
		
		try {
			StoreDao.updateStore(sl);
			Assertions.fail("Invalid Update Store ID Method is failded");
		}catch(IllegalArgumentException ex) {
			Assertions.assertEquals(StoreValidatorErrors.INVALID_STORE_ID, ex.getMessage());
		}
		
	}
	
	@Test 
	public void testInvalidDeleteStoreId() throws IllegalAccessException, DAOException {
		
		try {
			StoreDao.deleteStore(-1);
			Assertions.fail("Invalid Delete Store ID Method is failded");
		}catch(IllegalAccessException ex) {
			Assertions.assertEquals(StoreValidatorErrors.INVALID_STORE_ID, ex.getMessage());
		}
		
	}
	
	
	
}
