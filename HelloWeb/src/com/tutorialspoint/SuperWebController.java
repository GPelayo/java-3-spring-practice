package com.tutorialspoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SuperWebController {
   @RequestMapping("/*")
   public String superIndexPage() {     
      return "redirect:/pages/index.htm";
   }
}