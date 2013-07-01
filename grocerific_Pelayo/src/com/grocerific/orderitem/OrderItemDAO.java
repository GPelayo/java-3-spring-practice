package com.grocerific.orderitem;

import java.util.List;

import javax.sql.DataSource;

public interface OrderItemDAO {

	public void setDataSource(DataSource ds);

	public void createNewOrder(OrderItem orderItem);

	public OrderItem getOrderById(Integer orderId, Integer lineNumber);

	public List<OrderItem> listOrderItems();

	public void delete(Integer orderId, Integer lineNumber);

	public void update(OrderItem orderItem);
}
