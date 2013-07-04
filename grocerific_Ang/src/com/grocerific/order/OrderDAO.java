package com.grocerific.order;

import java.util.List;

import javax.sql.DataSource;

public interface OrderDAO {

	public void setDataSource(DataSource ds);

	public void createNewOrder(String orderDate, float total);

	public Order getOrderById(Integer id);

	public List<Order> listOrders();

	public void delete(Integer id);

	public void update(Order order);
}
