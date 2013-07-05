package com.yousap.controller;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.yousap.message.*;

@Controller
public class MessageController extends AbstractController{
	ArrayList<Message> messageList = new ArrayList<Message>();
	String lastUsedName = "";
	int postCount = 0;
	@RequestMapping(method = RequestMethod.GET, value = "/*")
	public String show404(){
		//TODO Redirect to 404 page Here
		return "redirect:topic";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/topic")
	public ModelAndView listMessages(@ModelAttribute Message message){
		//MessageJDBC messageJdbc = (MessageJDBC)getApplicationContext().getBean("messageJDBCTemplate");
		message.setUsername(lastUsedName);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("topic");
		mav.addObject("messageList", messageList /*messageJdbc.listMessages()*/);
		mav.addObject("message", message);
		return mav;
	}
	//TODO Redirect to Add page Notification
	@RequestMapping(method = RequestMethod.POST, value="/add") 
	public String saveAddedMessage(@ModelAttribute Message message) {		
		//MessageJDBC messageJdbc = (MessageJDBC)getApplicationContext().getBean("messageJDBCTemplate");
		lastUsedName = message.getUsername();
		message.setMessageID(postCount); //TODO Delete When DB works
		messageList.add(message);
		postCount++;
		return "redirect:topic";
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/delete") 
	public String deleteMessage(@RequestParam(value="messageID") Integer messageID, @RequestParam(value="lineNumber") Integer lineNumber){
		//MessageJDBC messageJdbc = (MessageJDBC)getApplicationContext().getBean("messageJDBCTemplate");
		//messageJdbc.delete(orderId, lineNumber);
		
		//TODO Delete From This to @ once JDBC is made
		Message message = new Message();
		
		for(Message iMessage : messageList)
		{
			if(iMessage.getMessageID().equals(messageID))
			{
				message = iMessage;
			}
		}
		
		messageList.remove(message);
		//@
		return "redirect:topic";
	}

	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		return null;
	}
}