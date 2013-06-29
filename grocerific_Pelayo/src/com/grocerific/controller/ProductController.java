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
	
	@RequestMapping(method = RequestMethod.GET, value = "/Products/list")
	public ModelAndView listProducts(){
		ProductJDBC productJdbc = (ProductJDBC)getApplicationContext().getBean("productJDBCTemplate");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/getAllProducts");
		mav.addObject("products", productJdbc.listProducts());
		return mav;
	}	
	
	@RequestMapping(method = RequestMethod.GET, value = "/Products/editProduct")
	public ModelAndView editProduct(@RequestParam(value="id") Integer id, @ModelAttribute Product newProduct) {
		ProductJDBC productJdbc = (ProductJDBC)getApplicationContext().getBean("productJDBCTemplate");
		newProduct = productJdbc.getProductById(id);
		String titleMsg = String.format("Editing %s", newProduct.getDescription())
			  ,headerMsg = String.format("Now Editing Product:", newProduct.getId(), newProduct.getDescription())
			  ,subheaderMsg = String.format("[%s] %s", newProduct.getId(), newProduct.getDescription());
		ModelAndView productModelView = new ModelAndView();
	

		productModelView.setViewName("editProduct");
		productModelView.addObject("product", newProduct);
		productModelView.addObject("titleMsg", titleMsg);
		productModelView.addObject("headerMsg", headerMsg);
		productModelView.addObject("subheaderMsg", subheaderMsg);
		return productModelView;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/Products/editProduct") 
	public String saveEditedProduct(@RequestParam(value="id") Integer id, @ModelAttribute Product product) {
		product.setId(id);
		ProductJDBC productJdbc = (ProductJDBC)getApplicationContext().getBean("productJDBCTemplate");
		productJdbc.update(product);		
		return "redirect:list";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/Products/addProduct")
	public ModelAndView editProduct(@ModelAttribute Product newProduct) {
		newProduct = new Product();
		
		ModelAndView productModelView = new ModelAndView();
		productModelView.setViewName("editProduct");
		productModelView.addObject("product", newProduct);
		productModelView.addObject("titleMsg", "Adding New Product");
		productModelView.addObject("headerMsg", "Adding New Product");
		productModelView.addObject("subheaderMsg", "");
		return productModelView;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/Products/addProduct") 
	public String saveAddedProduct(@ModelAttribute Product product) {
		ProductJDBC productJdbc = (ProductJDBC)getApplicationContext().getBean("productJDBCTemplate");
		productJdbc.createNewProduct(product.getDescription(), product.getSize(), product.getPrice());
		return "redirect:list";
	}	
	
	@RequestMapping(method = RequestMethod.GET, value="/Products/deleteProduct") 
	public String deleteProduct(@RequestParam(value="id") Integer id){
		ProductJDBC productJdbc = (ProductJDBC)getApplicationContext().getBean("productJDBCTemplate");
		productJdbc.delete(id);		
		return "redirect:list";
	}

	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		return null;
	}
}