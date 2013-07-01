package com.grocerific.orderitem;

import java.util.List;

import javax.sql.DataSource;

public interface OrderItemDAO {

	public void setDataSource(DataSource ds);

	public void createNewOrderItem(int orderItem, int lineNumber, int productId, int quantity, float unitPrice);

	public OrderItem getOrderItemById(Integer orderId, Integer lineNumber);

	public List<OrderItem> listOrderItems();

	public void delete(Integer orderId, Integer lineNumber);

	public void update(OrderItem orderItem);
}
