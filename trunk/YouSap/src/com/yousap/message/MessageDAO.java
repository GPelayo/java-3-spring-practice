package com.yousap.message;

import java.util.List;

import javax.sql.DataSource;

public interface MessageDAO {

	public void setDataSource(DataSource ds);

	public void createNewMessage(String username, String message_content);
	
	public Message getMessageById(Integer message_id);

	public List<Message> listMessages();

	public void delete(Integer message_id);

	public void update(Message message);
}
