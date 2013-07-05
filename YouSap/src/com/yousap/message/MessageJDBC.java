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

	public void createNewMessage(int message, String username, String message_content, String message_date) {
		String insertIntoOrders = "Insert into message (message_id, username, message_content, message_date) values (?, ?, ?, ?)";
		jdbcTemplate.update(insertIntoOrders, message, username, message_content, message_date);
	}

	public Message getMessageById(Integer message_id) {
		String selectMessageById = String.format("Select * from message where message_id = ?", message_id);
		Message message = jdbcTemplate.queryForObject(selectMessageById, new Object[]{message_id}, new MessageMapper());
		return message;
	}

	public List<Message> listMessages() {
		String selectAllMessages = "SELECT * from message BY message_id DESC";
		List<Message> messages = jdbcTemplate.query(selectAllMessages, new MessageMapper());
		return messages;
	}

	public void delete(Integer message_id) {
		String deleteMessages = "Delete from message where message_id=?";
		jdbcTemplate.update(deleteMessages, message_id);
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
