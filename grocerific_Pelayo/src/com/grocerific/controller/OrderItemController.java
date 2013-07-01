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

import com.grocerific.orderItem.*;

@Controller
public class OrderItemController extends AbstractController{
	
	@RequestMapping(method = RequestMethod.GET, value = "OrderItems/list")
	public ModelAndView listOrderItems(){
		OrderItemJDBC orderItemJdbc = (OrderItemJDBC)getApplicationContext().getBean("orderItemJDBCTemplate");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/getAllOrderItems");
		mav.addObject("orderItems", orderItemJdbc.listOrderItem());
		return mav;
	}	
	
	@RequestMapping(method = RequestMethod.GET, value = "/OrderItems/editOrderItem")
	public ModelAndView editOrderItem(@RequestParam(value="orderID") Integer orderId, @RequestParam(value="lineNumber") Integer lineNumber, @ModelAttribute OrderItem newOrderItem) {
		OrderItemJDBC orderItemJdbc = (OrderItemJDBC)getApplicationContext().getBean("orderItemJDBCTemplate");
		newOrderItem = orderItemJdbc.getOrderItemById(orderId, lineNumber);
		String titleMsg = String.format("Editing Order Item %s", newOrderItem.getProductId())
			  ,headerMsg = String.format("Now Editing Order Item %s", newOrderItem.getProductId());
		ModelAndView orderItemModelView = new ModelAndView();	

		orderItemModelView.setViewName("editOrderItem");
		orderItemModelView.addObject("orderItem", newOrderItem);
		orderItemModelView.addObject("titleMsg", titleMsg);
		orderItemModelView.addObject("headerMsg", headerMsg);
		orderItemModelView.addObject("subheaderMsg", "");
		return orderItemModelView;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/OrderItems/editOrderItem") 
	public String saveEditedOrderItem(@ModelAttribute OrderItem orderItem) {
		OrderItemJDBC orderItemJdbc = (OrderItemJDBC)getApplicationContext().getBean("orderItemJDBCTemplate");
		orderItemJdbc.update(orderItem);		
		return "redirect:list";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/OrderItems/addOrderItem")
	public ModelAndView editOrderItem(@ModelAttribute OrderItem newOrderItem) {
		newOrderItem = new OrderItem();
		
		ModelAndView orderItemModelView = new ModelAndView();
		orderItemModelView.setViewName("editOrderItem");
		orderItemModelView.addObject("orderItem", newOrderItem);
		orderItemModelView.addObject("titleMsg", "Adding New Order Item");
		orderItemModelView.addObject("headerMsg", "Adding New Order Item");
		orderItemModelView.addObject("subheaderMsg", "");
		return orderItemModelView;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/OrderItems/addOrderItem") 
	public String saveAddedOrderItem(@ModelAttribute OrderItem orderItem) {
		OrderItemJDBC orderItemJdbc = (OrderItemJDBC)getApplicationContext().getBean("orderItemJDBCTemplate");
		orderItemJdbc.createNewOrderItem(orderItem.getOrderId(), orderItem.getLineNumber(),orderItem.getProductId(), orderItem.getQuantity(), orderItem.getUnitPrice());
		return "redirect:list";
	}	
	
	@RequestMapping(method = RequestMethod.GET, value="/OrderItems/deleteOrderItem") 
	public String deleteOrderItem(@RequestParam(value="orderId") Integer orderId, @RequestParam(value="lineNumber") Integer lineNumber){
		OrderItemJDBC orderItemJdbc = (OrderItemJDBC)getApplicationContext().getBean("orderItemJDBCTemplate");
		orderItemJdbc.delete(orderId, lineNumber);		
		return "redirect:list";
	}

	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		return null;
	}
}