package com.fssa.spartansmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fssa.spartansmt.model.Product;
import com.fssa.spartansmt.validator.ProductValidatorErrors;

// TODO - WRITE COMMENTES

public class ProductDao {

	// Add Product Details to the Database Table through the Add Product Method
	public static boolean addProduct(Product product) throws DAOException {

		// Get Connection form Connection Util
		try (Connection con = ConnectionUtil.getConnection()) {

			// Declaring Query as a String and Using final Keyword
			final String query = "INSERT INTO products(product_title, product_price, product_image, store_id) values (?,?,?,?)";

			// Created Prepared Statement And It'll Execute Query
			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setString(1, product.getProduct_title());
				pst.setDouble(2, product.getProduct_price());
				pst.setString(3, product.getProduct_image());
				pst.setInt(4, product.getStore_id());
				pst.executeUpdate();

				System.out.println("Product Added Successfully To The Database");

			}

		} catch (SQLException ex) {
			throw new DAOException("Add Product to the Database Method is Failded");
		}

		return true;

	}

	// Update Product Details to tbe Database Table Through the UpdateProduct Method
	public static boolean updateProduct(Product product) throws DAOException, InvalidProductDetailsException {

		// Validating Store ID
		if (product.getProduct_id() <= 0) {
			throw new InvalidProductDetailsException(ProductValidatorErrors.INVALID_PRODUCT_ID);
		}

		// Get connection from connection util
		try (Connection con = ConnectionUtil.getConnection()) {

			final String query = "UPDATE products SET product_title = ?, product_price = ?, product_image = ? WHERE product_id = ?";
			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setString(1, product.getProduct_title());
				pst.setDouble(2, product.getProduct_price());
				pst.setString(3, product.getProduct_image());
				pst.setInt(4, product.getProduct_id());
				pst.executeUpdate();

				System.out.println("Product Updated Successfully");

			}

		} catch (SQLException ex) {
			throw new DAOException("Update Product Details to Datadase Method Is Failded");
		}

		return true;

	}

	public static boolean deleteProduct(int productId) throws DAOException, InvalidProductDetailsException {

		if (productId <= 0) {
			throw new InvalidProductDetailsException(ProductValidatorErrors.INVALID_PRODUCT_ID);
		}

		// Get Connection From Connection Util
		try (Connection con = ConnectionUtil.getConnection()) {

			// Declaring Delete Store Details Query as a String and declared as a final key
			final String query = "DELETE FROM products WHERE product_id = ?";

			// Created Prepared Statement and Executing Query
			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setInt(1, productId);
				pst.executeUpdate();

			}

		} catch (SQLException ex) {
			throw new DAOException("Error For Deleting Product Details");
		}

		// Print Statement
		System.out.println("Deleted Successfully");

		return true;

	}

	public boolean getAllProductDetails() throws DAOException {

		// Get Connection From Connection Util
		try (Connection con = ConnectionUtil.getConnection()) {

			// Get All Store Details from Database. Declared Query as a String and Declared
			// final keyword.
			final String query = "select * from products";

			// Connection Util Class CreateStatement Method Assigned by Statement Interface
			try (Statement st = con.createStatement()) {

				// Created ResultSet And Executing SQL Query
				try (ResultSet rs = st.executeQuery(query)) {

					// Get All Store Details using ResultSet and Printing Store Details One by One.
					while (rs.next()) {

						System.out.println("Product ID: " + rs.getInt("product_id") + ", Product Name: "
								+ rs.getString("product_title") + ", Product Price: " + rs.getDouble("product_price") + ", Product Image URL: " + rs.getString("product_image")
								+ ", Store ID: " + rs.getInt("store_id"));

					}

				}

			}

		} catch (SQLException ex) {
			throw new DAOException("Error for fetching Product Details");
		}

		return true;

	}

	// Main Method to test all the Method's
	// public static void main(String[] args) throws DAOException, InvalidProductDetailsException {

//		Product p = new Product("Mens Air Zoom Vomero 15 Running Shoe", 5999, "https://iili.io/HkeiZmb.webp", 1);
//
//		Product p1 = new Product();
//		p1.setProduct_id(1);
//		p1.setProduct_price(2999);
//		p1.setProduct_image("https://iili.io/HkeiZmb.webp");
//		p1.setProduct_title("Hello Everyone");
		
//		addProduct(p);

//		updateProduct(p1);

//		deleteProduct(p1.getProduct_id());

//		getAllProductDetails();
		
	}

//}
