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
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/getAllProducts");
		mav.addObject("products", productJdbc.listProducts());
		return mav;
	}	
	
	@RequestMapping(method =RequestMethod.GET, value = "/products/editProduct")
	public ModelAndView editProduct(@RequestParam(value="id") Integer id, @ModelAttribute Product newProduct) {
		ProductJDBC productJdbc = (ProductJDBC)getApplicationContext().getBean("productJDBCTemplate");
		String titleMsg, headerMsg, subheaderMsg;
	
		newProduct = productJdbc.getProductById(id);
		titleMsg = String.format("Editing %s", newProduct.getDescription());
		headerMsg = String.format("Now Editing Product:", newProduct.getId()
				, newProduct.getDescription());
		subheaderMsg = String.format("[%s] %s", newProduct.getId()
				, newProduct.getDescription());
		
		ModelAndView productModelView = new ModelAndView();
		productModelView.setViewName("editProduct");
		productModelView.addObject("product", newProduct);
		productModelView.addObject("titleMsg", titleMsg);
		productModelView.addObject("headerMsg", headerMsg);
		productModelView.addObject("subheaderMsg", subheaderMsg);
		return productModelView;
	}
	
	@RequestMapping(method =RequestMethod.GET, value = "/products/editProduct")
	public ModelAndView editProduct(@ModelAttribute Product newProduct) {
		ProductJDBC productJdbc = (ProductJDBC)getApplicationContext().getBean("productJDBCTemplate");
		String titleMsg, headerMsg, subheaderMsg;
		newProduct = new Product();
		titleMsg = "Adding New Product";
		headerMsg = titleMsg;
		subheaderMsg = "";
		
		ModelAndView productModelView = new ModelAndView();
		productModelView.setViewName("editProduct");
		productModelView.addObject("product", newProduct);
		productModelView.addObject("titleMsg", titleMsg);
		productModelView.addObject("headerMsg", headerMsg);
		productModelView.addObject("subheaderMsg", subheaderMsg);
		return productModelView;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/products/editProduct") 
	public String saveProduct(@RequestParam(value="id") Integer id, @ModelAttribute Product product) {
		product.setId(id);
		ProductJDBC productJdbc = (ProductJDBC)getApplicationContext().getBean("productJDBCTemplate");
		productJdbc.update(product);		
		return "redirect: list";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/products/deleteProduct") 
	public String deleteProduct(@RequestParam(value="id") Integer id){
		ProductJDBC productJdbc = (ProductJDBC)getApplicationContext().getBean("productJDBCTemplate");
		productJdbc.delete(id);		
		return "redirect: list";
	}

	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		return null;
	}
}