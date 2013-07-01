package com.grocerific.inventory;

import java.util.List;

import javax.sql.DataSource;

public interface InventoryDAO {

	public void setDataSource(DataSource ds);

	public void createNewInventory(int product_id, int quantiy);

	public Inventory getInventoryById(Integer id);

	public List<Inventory> listInventory();

	public void delete(Integer id);

	public void update(Inventory inventory);
}
