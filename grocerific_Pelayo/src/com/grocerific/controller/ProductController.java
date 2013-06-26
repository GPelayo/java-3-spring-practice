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
	/*
	@RequestMapping(value = "resource/css/style.css")
	public String showYoStylin()
	{
		System.out.println("CSS access attempted");
		return "resource/css/style.css";
	}
	*/
	
	@RequestMapping(method = RequestMethod.GET, value = "/products/list")
	public ModelAndView listProducts(){
		ProductJDBC productJdbc = (ProductJDBC)getApplicationContext().getBean("productJDBCTemplate");
		System.out.println("List Accessed");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/getAllProducts");
		mav.addObject("products", productJdbc.listProducts());
		return mav;
	}

	@RequestMapping(method=RequestMethod.POST, value="/products/list") 
	public String saveProduct(@RequestParam(value="productId") Integer id, @ModelAttribute Product product){
		product.setId(id);
		ProductJDBC productJdbc = (ProductJDBC)getApplicationContext().getBean("productJDBCTemplate");
		productJdbc.update(product);		
		return "list";
	}
	
	@RequestMapping(method =RequestMethod.GET, value = "/products/editProduct")
	public ModelAndView editProduct(@RequestParam(value="id") Integer id, @ModelAttribute("edit-product") Product productToBeEdited)
	{
		ProductJDBC productJdbc = (ProductJDBC)getApplicationContext().getBean("productJDBCTemplate");
		productToBeEdited = productJdbc.getProductById(id);
		return initializeProductModel(productToBeEdited, "editProduct");
	}

	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		return null;
	}
	
	private ModelAndView initializeProductModel(Product product, String viewName)
	{
		ModelAndView productModelView = new ModelAndView();
		productModelView.setViewName(viewName);
		productModelView.addObject("productId", product.getId());
		productModelView.addObject("description", product.getDescription());
		productModelView.addObject("size", product.getSize());
		productModelView.addObject("price", product.getPrice());
		
		return productModelView;
	}
}