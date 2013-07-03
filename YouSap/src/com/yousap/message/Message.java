package com.yousap.message;

public class Message {
	private Integer messageID;
	private Integer messageText;
	private Integer productID;
	private Integer username;
	private float parentMessageID;
	
	public Integer getMessageID() {
		return messageID;
	}
	public void setMessageID(Integer messageID) {
		this.messageID = messageID;
	}
	public Integer getMessageText() {
		return messageText;
	}
	public void setMessageText(Integer messageText) {
		this.messageText = messageText;
	}
	public Integer getProductID() {
		return productID;
	}
	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	public Integer getUsername() {
		return username;
	}
	public void setUsername(Integer username) {
		this.username = username;
	}
	public float getParentMessageID() {
		return parentMessageID;
	}
	public void setParentMessageID(float parentMessageID) {
		this.parentMessageID = parentMessageID;
	}
}

