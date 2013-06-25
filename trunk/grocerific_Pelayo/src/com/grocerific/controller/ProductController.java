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

import com.grocerific.product.*;

@Controller
public class ProductController extends AbstractController{
	ProductJDBC productJdbc;
	
	@RequestMapping(method = RequestMethod.GET, value = "/wew")
	public String testThingy()
	{
		return "redirect:/products/list";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/products/list")
	public ModelAndView listProducts(){
		System.out.println("List Accessed");
		productJdbc = (ProductJDBC)getApplicationContext().getBean("productJDBCTemplate");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/getAllProducts");
		mav.addObject("products", productJdbc.listProducts());
		return mav;
	}

	@RequestMapping(method =RequestMethod.GET, value = "/editProduct")
	public ModelAndView editProduct(@RequestParam(value="id") Integer id)
	{		
		productJdbc = (ProductJDBC)getApplicationContext().getBean("productJDBCTemplate");
		Product product = productJdbc.getProductById(id);
		
		ModelAndView productModelView = new ModelAndView();
		productModelView.setViewName("editProduct");
		productModelView.addObject("id", product.getId());
		productModelView.addObject("description", product.getDescription());
		productModelView.addObject("size", product.getSize());
		productModelView.addObject("price", product.getPrice());
		
		System.out.print(product.toString());
		return productModelView;
	}

	@RequestMapping(method=RequestMethod.POST,value="edit") 
	public String savePerson(@ModelAttribute Product product){
		return "It works";
	}

	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		return null;
	}

}