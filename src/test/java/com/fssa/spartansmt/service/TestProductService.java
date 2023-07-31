package com.fssa.spartansmt.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.spartansmt.dao.DAOException;
import com.fssa.spartansmt.dao.InvalidProductDetailsException;
import com.fssa.spartansmt.model.Product;

public class TestProductService {

	public Product demoProduct() {

		Product p1 = new Product();
		p1.setProduct_id(6);
		p1.setProduct_title("Test Product Service");
		p1.setProduct_price(2900);
		p1.setProduct_image("https://iili.io/HkeiZmb.webp");
		p1.setStore_id(2);

		return p1;

	}

	@Test
	public void testValidAddProduct() throws InvalidProductDetailsException, DAOException {

		TestProductService tps = new TestProductService();
		Assertions.assertTrue(ProductService.addProduct(tps.demoProduct()));

	}

	@Test
	public void testValidUpdateProduct() throws InvalidProductDetailsException, DAOException {
		TestProductService tps = new TestProductService();
		Assertions.assertTrue(ProductService.updateProduct(tps.demoProduct()));
	}

	@Test
	public void testValidDeleteProduct() throws InvalidProductDetailsException, DAOException {
		Assertions.assertTrue(ProductService.deleteProduct(6));
	}

	@Test
	public void testValidGetAllProductDetails() throws DAOException {
		ProductService ps = new ProductService();
		Assertions.assertTrue(ps.getAllProductDetails());
	}
	
}
