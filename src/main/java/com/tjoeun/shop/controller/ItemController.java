package com.tjoeun.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/admin/item")
public class ItemController {
	
	@GetMapping("/register")
	public String register() {
		return "item/register";
	}

}
