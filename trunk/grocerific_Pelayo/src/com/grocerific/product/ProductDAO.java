package com.grocerific.product;

import java.util.List;

import javax.sql.DataSource;

public interface ProductDAO {

	public void setDataSource(DataSource ds);

	public void createNewProduct(String description, String size, float price);

	public Product getProductById(Integer id);

	public List<Product> listProducts();

	public void delete(Integer id);

	public void update(Product product);
}
