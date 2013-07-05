package com.yousap.message;

import java.sql.Date;

public class Message {
	private Integer messageID;
	private String messageText;
	private String username;
	private Integer parentMessageID;
	private Date date;
	
	public Integer getMessageID() {
		return messageID;
	}
	public void setMessageID(Integer messageID) {
		this.messageID = messageID;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getParentMessageID() {
		return parentMessageID;
	}
	public void setParentMessageID(Integer parentMessageID) {
		this.parentMessageID = parentMessageID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

	
}

