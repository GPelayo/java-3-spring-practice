package com.grocerific.product;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class ProductJDBC implements ProductDAO{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource ds) {
		dataSource = ds;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void createNewProduct(String description, String size, float price) {
		String insertIntoProducts = String.format("Insert into products (description, size, price) values (%s, %s, %s)", description, size, price);
		jdbcTemplate.update(insertIntoProducts, description, size, price);
	}

	public Product getProductById(Integer id) {
		String selectProductById = String.format("Select * from products where id = %s", id);
		//Product product = jdbcTemplate.queryForObject(selectProductById, new Object[]{id}, new ProductMapper());
		Product product = jdbcTemplate.query(selectProductById, new ProductMapper()).get(0);
		return product;
	}

	public List<Product> listProducts() {
		String selectAllProducts = "select * from products ORDER BY price DESC";
		List<Product> products = jdbcTemplate.query(selectAllProducts, new ProductMapper());
		return products;
	}

	public void delete(Integer id) {
		String deleteProduct = String.format("delete from products where id = %s", id);
		jdbcTemplate.update(deleteProduct, id);
	}

	@Override
	public void update(Product product) {
		String updateProduct = String.format("update products set description = %s where id = %s", product.getId(), product.getDescription());
		jdbcTemplate.update(updateProduct, product.getId(),product.getDescription());
	}
}
