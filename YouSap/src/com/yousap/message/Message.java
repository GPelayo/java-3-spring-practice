package com.yousap.message;

public class Message {
	private Integer messageID;
	private String messageText;
	private Integer productID;
	private String username;
	private float parentMessageID;
	
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
	public Integer getProductID() {
		return productID;
	}
	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public float getParentMessageID() {
		return parentMessageID;
	}
	public void setParentMessageID(float parentMessageID) {
		this.parentMessageID = parentMessageID;
	}
	
	
}

