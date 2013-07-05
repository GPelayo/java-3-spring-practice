package com.yousap.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.yousap.exception.InvalidInputException;
import com.yousap.message.*;

@Controller
public class MessageController extends AbstractController{	
	@RequestMapping(method = RequestMethod.GET, value = "/*")
	public String show404() {
		//TODO Redirect to 404 page Here
		return "redirect:topic";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/topic")
	public ModelAndView listMessages(@ModelAttribute Message message) {
		MessageJDBC messageJdbc = (MessageJDBC)getApplicationContext().getBean("messageJDBCTemplate");
		ModelAndView mav = new ModelAndView();
		
		message.setParentMessageID(-1);
		mav.addObject("messageList", messageJdbc.listMessages());
		mav.addObject("message", message);
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/highlight")
	public ModelAndView highlightMessage(@RequestParam(value="parentID") Integer parentID, @ModelAttribute Message message) {
		MessageJDBC messageJdbc = (MessageJDBC)getApplicationContext().getBean("messageJDBCTemplate");
		ModelAndView mav = new ModelAndView();
		
		message.setParentMessageID(-1);
		mav.setViewName("topic");
		mav.addObject("messageList", messageJdbc.listMessages());
		mav.addObject("message", message);
		mav.addObject("highlightID", parentID);
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/add") 
	public String saveAddedMessage(@ModelAttribute Message message) {		
		if(message.getMessageText().length() <= 0)
		{
			throw new InvalidInputException("Invalid Input Blank Message");
		}
		if(message.getUsername().length() <= 0)
		{
			message.setUsername("Nameless");
		}
		
		MessageJDBC messageJdbc = (MessageJDBC)getApplicationContext().getBean("messageJDBCTemplate");
		message.setNestLevel(0);
		message.setDate(new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
		messageJdbc.createNewMessage(message);
		return "redirect:topic#bottom";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="edit") 
	public ModelAndView showEditView(@RequestParam(value="id") Integer messageID, @ModelAttribute Message message) {
		MessageJDBC messageJdbc = (MessageJDBC)getApplicationContext().getBean("messageJDBCTemplate");
		ModelAndView productModelView = new ModelAndView();
		
		productModelView.setViewName("edit");
		message = messageJdbc.getMessageById(messageID);
		productModelView.addObject(message);
		return productModelView;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="edit") 
	public String editMessage(@RequestParam(value="id") Integer messageID, @ModelAttribute Message message) {
		if(message.getMessageText().length() <= 0)
		{
			throw new InvalidInputException("Invalid Input: Blank Message");
		}
		
		MessageJDBC messageJdbc = (MessageJDBC)getApplicationContext().getBean("messageJDBCTemplate");
		Message oldmessage = messageJdbc.getMessageById(messageID);
		oldmessage.setMessageText(message.getMessageText());
		messageJdbc.update(oldmessage);
		return String.format("redirect:topic#%s", messageID);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="delete") 
	public String deleteMessage(@RequestParam(value="id") Integer messageID) {
		MessageJDBC messageJdbc = (MessageJDBC)getApplicationContext().getBean("messageJDBCTemplate");
		
		messageJdbc.delete(messageID);
		return "redirect:topic";
	}
	
	protected ArrayList<Message> organizeList(ArrayList<Message> messages) {		
		return messages;
	}
	
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		return null;
	}
}