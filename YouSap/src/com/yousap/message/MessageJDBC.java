package com.yousap.message;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class MessageJDBC /*implements MessageDAO*/{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource ds) {
		dataSource = ds;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void createNewMessage(int message, int lineNumber, int productId, int quantity, float unitPrice) {
		String insertIntoOrders = "Insert into orderitems (order_id, line_number, product_id, quantity, unit_price) values (?, ?, ?, ?, ?)";
		jdbcTemplate.update(insertIntoOrders, message, lineNumber, productId, quantity, unitPrice);
	}

	public Message getMessageById(Integer orderId, Integer lineNumber) {
		String selectOrderById = String.format("Select * from orderitems where order_id = ? AND line_number=?", orderId, lineNumber);
		Message order = jdbcTemplate.queryForObject(selectOrderById, new Object[]{orderId, lineNumber}, new MessageMapper());
		return order;
	}

	public List<Message> listMessages() {
		String selectAllMessages = "SELECT * from orderitems ORDER BY order_id DESC";
		List<Message> orders = jdbcTemplate.query(selectAllMessages, new MessageMapper());
		return orders;
	}

	public void delete(Integer orderId, Integer lineNumber) {
		String deleteMessages = "Delete from orderitems where order_id=? AND line_number=?";
		jdbcTemplate.update(deleteMessages, orderId, lineNumber);
	}
	
	/*
	@Override
	public void update(Message message) {
		String updateOrder = String.format("UPDATE orderitems SET product_id=?, quantity=?, unit_price=? where order_id=? AND line_number=?");
		jdbcTemplate.update(updateOrder, message.getProductId(), message.getQuantity(), message.getUnitPrice()
									   , message.getOrderId(), message.getLineNumber());
	}
	*/
}
