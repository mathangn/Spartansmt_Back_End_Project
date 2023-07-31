package com.fssa.spartansmt.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.spartansmt.model.Product;
import com.fssa.spartansmt.validator.ProductValidatorErrors;

public class TestProductDao {

	public static Product validProduct() {

		Product p1 = new Product();
		p1.setProduct_id(15);
		p1.setProduct_title("Test Product Dao");
		p1.setProduct_price(8999);
		p1.setProduct_image(
				"https://user-images.githubusercontent.com/116251925/226127453-f9fed506-9089-4786-b041-4bd5713c3d88.png");
		p1.setStore_id(3);

		return p1;

	}
	
	
	// Valid Test Cases
	public static Product invalidProduct() {
		Product p1 = new Product();
		p1.setProduct_id(-1);
		return p1;
	}

	@Test
	public void testValidAddProduct() throws DAOException {
		Assertions.assertTrue(ProductDao.addProduct(validProduct()));
	}

	@Test
	public void testValidUpdateProduct() throws DAOException, InvalidProductDetailsException {
		Assertions.assertTrue(ProductDao.updateProduct(validProduct()));
	}

	@Test
	public void testValidDelectProduct() throws DAOException, InvalidProductDetailsException {
		Assertions.assertTrue(ProductDao.deleteProduct(validProduct().getProduct_id()));
	}

	@Test
	public void testValidGetProductDetails() throws DAOException, InvalidProductDetailsException {
		ProductDao pd = new ProductDao();
		Assertions.assertTrue(pd.getAllProductDetails());
	}

	
	// Invalid Test Cases
	@Test
	public void testInvalidAddProduct() {
		
		try {
			ProductDao.addProduct(invalidProduct());
		}catch(DAOException ex) {
			Assertions.assertEquals("Add Product to the Database Method is Failded", ex.getMessage());
		}
		
	}
	
	@Test
	public void testInvalidUpdateProduct() throws InvalidProductDetailsException, DAOException {
		
		try {
			Product p2 = new Product();
			p2.setProduct_id(2);
			ProductDao.updateProduct(p2);
		}catch(DAOException ex) {
			Assertions.assertEquals("Update Product Details to Datadase Method Is Failded", ex.getMessage());
		}
		
	}
	
	@Test
	public void testInvalidUpdateProductId() throws InvalidProductDetailsException, DAOException {
		
		try {
			ProductDao.updateProduct(invalidProduct());
		}catch(InvalidProductDetailsException ex) {
			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_ID, ex.getMessage());
		}
		
	}

	@Test
	public void testInvalidDelectProductId() throws InvalidProductDetailsException, DAOException {
		
		try {
			ProductDao.deleteProduct(invalidProduct().getProduct_id());
		}catch(InvalidProductDetailsException ex) {
			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_ID, ex.getMessage());
		}
		
	}



}
