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

import com.grocerific.inventory.*;
@Controller
public class InventoryController extends AbstractController{
	
	@RequestMapping(method = RequestMethod.GET, value = "Inventory/list")
	public ModelAndView listInventorys(){
		InventoryJDBC inventoryJdbc = (InventoryJDBC)getApplicationContext().getBean("inventoryJDBCTemplate");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/getAllInventory");
		mav.addObject("inventories", inventoryJdbc.listInventory());
		return mav;
	}	
	
	@RequestMapping(method = RequestMethod.GET, value = "/Inventory/editInventory")
	public ModelAndView editInventory(@RequestParam(value="id") Integer id, @ModelAttribute Inventory newInventory) {
		InventoryJDBC inventoryJdbc = (InventoryJDBC)getApplicationContext().getBean("inventoryJDBCTemplate");
		newInventory = inventoryJdbc.getInventoryById(id);
		String titleMsg = String.format("Editing Inventory of Product %s", newInventory.getProductId())
			  ,headerMsg = String.format("Now Editing Inventory of", newInventory.getProductId())
			  ,subheaderMsg = String.format("Product %s", newInventory.getProductId());
		ModelAndView inventoryModelView = new ModelAndView();	

		inventoryModelView.setViewName("editInventory");
		inventoryModelView.addObject("inventory", newInventory);
		inventoryModelView.addObject("titleMsg", titleMsg);
		inventoryModelView.addObject("headerMsg", headerMsg);
		inventoryModelView.addObject("subheaderMsg", subheaderMsg);
		return inventoryModelView;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/Inventory/editInventory") 
	public String saveEditedInventory(@ModelAttribute Inventory inventory) {
		InventoryJDBC inventoryJdbc = (InventoryJDBC)getApplicationContext().getBean("inventoryJDBCTemplate");
		inventoryJdbc.update(inventory);		
		return "redirect:list";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/Inventory/addInventory")
	public ModelAndView editInventory(@ModelAttribute Inventory newInventory) {
		newInventory = new Inventory();
		
		ModelAndView inventoryModelView = new ModelAndView();
		inventoryModelView.setViewName("editInventory");
		inventoryModelView.addObject("inventory", newInventory);
		inventoryModelView.addObject("titleMsg", "Adding New Inventory");
		inventoryModelView.addObject("headerMsg", "Adding New Inventory");
		inventoryModelView.addObject("subheaderMsg", "");
		return inventoryModelView;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/Inventory/addInventory") 
	public String saveAddedInventory(@ModelAttribute Inventory inventory) {
		InventoryJDBC inventoryJdbc = (InventoryJDBC)getApplicationContext().getBean("inventoryJDBCTemplate");
		inventoryJdbc.createNewInventory(inventory.getProductId(), inventory.getQuantity());
		return "redirect:list";
	}	
	
	@RequestMapping(method = RequestMethod.GET, value="/Inventory/deleteInventory") 
	public String deleteInventory(@RequestParam(value="id") Integer id){
		InventoryJDBC inventoryJdbc = (InventoryJDBC)getApplicationContext().getBean("inventoryJDBCTemplate");
		inventoryJdbc.delete(id);		
		return "redirect:list";
	}

	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		return null;
	}
}