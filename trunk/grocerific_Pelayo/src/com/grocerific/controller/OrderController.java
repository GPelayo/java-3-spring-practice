package com.grocerific.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.grocerific.order.*;

@Controller
public class OrderController extends AbstractController{
	
	@RequestMapping(method = RequestMethod.GET, value = "/Orders/list")
	public ModelAndView listOrders(){
		OrderJDBC orderJdbc = (OrderJDBC)getApplicationContext().getBean("orderJDBCTemplate");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/getAllOrders");
		mav.addObject("orders", orderJdbc.listOrders());
		return mav;
	}	
	
	@RequestMapping(method = RequestMethod.GET, value = "/Orders/editOrder")
	public ModelAndView editOrder(@RequestParam(value="id") Integer id, @ModelAttribute Order newOrder) {
		OrderJDBC orderJdbc = (OrderJDBC)getApplicationContext().getBean("orderJDBCTemplate");
		String titleMsg = String.format("Editing Order %s", newOrder.getId())
			  ,headerMsg = String.format("Now Editing Order: %s", newOrder.getId());
		ModelAndView orderModelView = new ModelAndView();
	
		newOrder = orderJdbc.getOrderById(id);		
		orderModelView.setViewName("editOrder");
		orderModelView.addObject("order", newOrder);
		orderModelView.addObject("titleMsg", titleMsg);
		orderModelView.addObject("headerMsg", headerMsg);
		return orderModelView;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/Orders/editOrder") 
	public String saveEditedOrder(@RequestParam(value="id") Integer id, @ModelAttribute Order order) {
		order.setId(id);
		OrderJDBC orderJdbc = (OrderJDBC)getApplicationContext().getBean("orderJDBCTemplate");
		orderJdbc.update(order);		
		return "redirect:list";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/Orders/addOrder")
	public ModelAndView editOrder(@ModelAttribute Order newOrder) {
		newOrder = new Order();
		
		ModelAndView OrderModelView = new ModelAndView();
		OrderModelView.setViewName("editOrder");
		OrderModelView.addObject("order", newOrder);
		OrderModelView.addObject("titleMsg", "Adding New Order");
		OrderModelView.addObject("headerMsg", "Adding New Order");
		OrderModelView.addObject("subheaderMsg", "");
		return OrderModelView;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/Orders/addOrder") 
	public String saveAddedOrder(@ModelAttribute Order order) {
		OrderJDBC orderJdbc = (OrderJDBC)getApplicationContext().getBean("orderJDBCTemplate");
		orderJdbc.createNewOrder(order.getOrderDate(), order.getTotal());
		return "redirect:list";
	}	
	
	@RequestMapping(method = RequestMethod.GET, value="/Orders/deleteOrder") 
	public String deleteOrder(@RequestParam(value="id") Integer id){
		OrderJDBC orderJdbc = (OrderJDBC)getApplicationContext().getBean("orderJDBCTemplate");
		orderJdbc.delete(id);		
		return "redirect:list";
	}

	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		return null;
	}
}