package com.grocerific.orderitem;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrderItemJDBC implements OrderItemDAO{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource ds) {
		dataSource = ds;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void createNewOrder(OrderItem orderItem) {
		String insertIntoOrders = "Insert into orderitems (order_id, line_number, product_id, quantity, unit_price) values (?, ?, ?, ?, ?)";
		jdbcTemplate.update(insertIntoOrders, orderItem.getLineNumber(), orderItem.getOrderId(), orderItem.getProductId()
											, orderItem.getQuantity(), orderItem.getUnitPrice());
	}

	public OrderItem getOrderById(Integer orderId, Integer lineNumber) {
		String selectOrderById = String.format("Select * from orderitems where order_id = ? AND line_number=?", orderId, lineNumber);
		OrderItem order = jdbcTemplate.queryForObject(selectOrderById, new Object[]{orderId, lineNumber}, new OrderItemMapper());
		return order;
	}

	public List<OrderItem> listOrderItems() {
		String selectAllOrderItems = "SELECT * from orderitems ORDER BY order_id DESC";
		List<OrderItem> orders = jdbcTemplate.query(selectAllOrderItems, new OrderItemMapper());
		return orders;
	}

	public void delete(Integer orderId, Integer lineNumber) {
		String deleteOrderItems = "Delete from orderitems where order_id=? AND line_number=?";
		jdbcTemplate.update(deleteOrderItems, orderId, lineNumber);
	}

	@Override
	public void update(OrderItem orderItem) {
		String updateOrder = String.format("UPDATE orderitems SET product_id=?, quanity=?, unit_price=? where order_id=? AND line_number=?");
		jdbcTemplate.update(updateOrder, orderItem.getProductId(), orderItem.getQuantity(), orderItem.getQuantity(), orderItem.getUnitPrice()
									   , orderItem.getOrderId(), orderItem.getClass());
	}
}
