package com.yousap.message;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MessageMapper implements RowMapper<Message>{
	
	@Override
	public Message mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		Message message = new Message();
		
		message.setMessageID(resultSet.getInt("messageID"));
		message.setMessageText(resultSet.getInt("messageText"));
		return message;
	}
}