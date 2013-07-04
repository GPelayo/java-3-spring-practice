package com.grocerific.inventory;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class InventoryMapper implements RowMapper<Inventory>{

	@Override
	public Inventory mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		Inventory inventory = new Inventory();
		inventory.setProductId(resultSet.getInt("product_id"));
		inventory.setQuantity(resultSet.getInt("quantity"));
		return inventory;
	}
}
