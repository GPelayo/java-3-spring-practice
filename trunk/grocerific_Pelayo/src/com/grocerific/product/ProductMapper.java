package com.grocerific.product;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductMapper implements RowMapper<Product>{

	@Override
	public Product mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		Product product = new Product();
		product.setId(resultSet.getInt("id"));
		product.setDescription(resultSet.getString("description"));
		product.setSize(resultSet.getString("size"));
		product.setPrice(resultSet.getFloat("price"));
		return product;
	}
}
