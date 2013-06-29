package com.grocerific.inventory;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class InventoryJDBC implements InventoryDAO{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource ds) {
		dataSource = ds;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void createNewInventory(int productId, int quantity) {
		String insertIntoInventorys = "Insert into inventory (product_id, quantity) values (?, ?)";
		jdbcTemplate.update(insertIntoInventorys, productId, quantity);
	}

	public Inventory getInventoryById(Integer id) {
		String selectInventoryById = String.format("Select * from inventory where product_id = ?", id);
		Inventory inventory = jdbcTemplate.queryForObject(selectInventoryById, new Object[]{id}, new InventoryMapper());
		return inventory;
	}

	public List<Inventory> listInventorys() {
		String selectAllInventorys = "SELECT * from inventory ORDER BY product_id DESC";
		List<Inventory> inventory = jdbcTemplate.query(selectAllInventorys, new InventoryMapper());
		return inventory;
	}

	public void delete(Integer id) {
		String deleteInventory = "Delete from inventory where product_id = ?";
		jdbcTemplate.update(deleteInventory, id);
	}

	@Override
	public void update(Inventory inventory) {
		String updateInventory = String.format("UPDATE inventory SET product_id=?, quantity=?");
		jdbcTemplate.update(updateInventory, inventory.getProductId(), inventory.getQuantity());
	}
}
