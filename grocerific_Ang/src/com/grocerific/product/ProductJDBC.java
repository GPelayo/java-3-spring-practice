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
		String insertIntoProducts = "Insert into products (description, size, price) values (?, ?, ?)";
		jdbcTemplate.update(insertIntoProducts, description, size, price);
	}

	public Product getProductById(Integer id) {
		String selectProductById = String.format("Select * from products where id = ?", id);
		Product product = jdbcTemplate.queryForObject(selectProductById, new Object[]{id}, new ProductMapper());
		return product;
	}

	public List<Product> listProducts() {
		String selectAllProducts = "SELECT * from products ORDER BY price DESC";
		List<Product> products = jdbcTemplate.query(selectAllProducts, new ProductMapper());
		return products;
	}

	public void delete(Integer id) {
		String deleteProduct = "Delete from products where id = ?";
		jdbcTemplate.update(deleteProduct, id);
	}

	@Override
	public void update(Product product) {
		String updateProduct = String.format("UPDATE products SET description=?, size=?, price=?  where id = ?");
		jdbcTemplate.update(updateProduct, product.getDescription(), product.getSize(), product.getPrice(), product.getId());
	}
}
