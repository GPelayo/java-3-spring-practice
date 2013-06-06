package com.practicum;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PeopleController{
	@RequestMapping("/home")
		public String showHome() {
			return "home";
	}

	List<People> people = new ArrayList<People>();
	@RequestMapping(value = "/person/list")
	public String showPeopleList(Model mModel) {
		people.add(new People(0, "Steve", "Jobs"));
		mModel.addAttribute("people", people);
		return "../people/list";
	}
	
	@RequestMapping(value = "/test")
	public String showTest(Model mModel) {	
		People mPeps = new People(0, "Steve", "Jobs");
		mModel.addAttribute("id", mPeps.getId());
		mModel.addAttribute("firstname", mPeps.getFirstName());
		mModel.addAttribute("lastname", mPeps.getLastName());
		return "outputTest";
	}

}