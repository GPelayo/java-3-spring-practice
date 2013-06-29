package com.grocerific.inventory;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class InventoryMapper implements RowMapper<Inventory>{

	@Override
	public Inventory mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		Inventory inventory = new Inventory();
		inventory.setProduct_id(resultSet.getInt("id"));
		inventory.setQuanity(resultSet.getInt("quantity"));
		return inventory;
	}
}
