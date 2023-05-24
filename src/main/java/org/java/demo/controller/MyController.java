package org.java.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MyController {
	private final static String MY_NAME = "Donato";
	private final static String MY_LASTNAME = "Montrone";
	
	@GetMapping("")
	public String getName(Model model) {
		model.addAttribute("name", MY_NAME);
		model.addAttribute("lastname", MY_LASTNAME);
		
		return "index";
	}
	
	
}
