package com.yousap.message;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MessageMapper implements RowMapper<Message>{
	
	@Override
	public Message mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		Message message = new Message();
		
		message.setMessageID(resultSet.getInt("message_id"));
		message.setMessageText(resultSet.getString("message_content"));
		message.setUsername(resultSet.getString("username"));
		message.setDate(resultSet.getString("message_date"));
		message.setParentMessageID(resultSet.getInt("parent_message_id"));
		return message;
	}
}