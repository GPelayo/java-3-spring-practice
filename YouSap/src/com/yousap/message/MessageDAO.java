package com.yousap.message;

import java.util.List;

import javax.sql.DataSource;

public interface MessageDAO {

	public void setDataSource(DataSource ds);

	public void createNewMessage(Message orderItem);
	
	public Message getMessageById(Integer orderId, Integer lineNumber);

	public List<Message> listMessages();

	public void delete(Integer orderId, Integer lineNumber);

	public void update(Message orderItem);
}
