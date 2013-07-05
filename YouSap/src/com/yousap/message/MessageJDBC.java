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

	public void createNewMessage(Message newMessage) {
		String insertIntoOrders = "Insert into message (username, message_content, message_date, parent_message_id) values (?, ?, ?, ?)";		
		jdbcTemplate.update(insertIntoOrders, newMessage.getUsername(), newMessage.getMessageText(), newMessage.getDate(), newMessage.getParentMessageID());
	}

	public Message getMessageById(Integer message_id) {
		String selectMessageById = String.format("Select * from message where message_id = ?", message_id);
		Message message = jdbcTemplate.queryForObject(selectMessageById, new Object[]{message_id}, new MessageMapper());
		return message;
	}

	public List<Message> listMessages() {
		String selectAllMessages = "SELECT * from message ORDER BY message_id ASC";
		List<Message> messages = jdbcTemplate.query(selectAllMessages, new MessageMapper());
		return messages;
	}

	public void delete(Integer message_id) {
		String deleteMessages = "Delete from message where message_id=?";
		jdbcTemplate.update(deleteMessages, message_id);
	}
	
	public void update(Message message) {
		String updateOrder = String.format("UPDATE message SET message_content=?, message_date=?, parent_message_id=?, username=? where message_id=?");
		jdbcTemplate.update(updateOrder, message.getMessageText(), message.getDate()
									   , message.getParentMessageID(), message.getUsername(), message.getMessageID());
	}
}
