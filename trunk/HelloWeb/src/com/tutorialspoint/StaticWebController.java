package com.tutorialspoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StaticWebController {

   @RequestMapping(value = "/static-index", method = RequestMethod.GET)
   public String index() {
	   return "static-index";
   }
   
   @RequestMapping(value = "/static-page", method = RequestMethod.GET)
   public String redirect() {
     
      return "redirect:/pages/final.htm";
   }
}