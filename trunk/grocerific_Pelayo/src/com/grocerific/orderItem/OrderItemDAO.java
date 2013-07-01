package com.grocerific.orderItem;

import java.util.List;

import javax.sql.DataSource;

public interface OrderItemDAO {

	public void setDataSource(DataSource ds);

	public void createNewOrder(String orderDate, float total);

	public OrderItem getOrderById(Integer id);

	public List<OrderItem> listOrders();

	public void delete(Integer id);

	public void update(OrderItem order);
}
