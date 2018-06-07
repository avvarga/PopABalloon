package com.avvarga.popaballoon.controllers;

import org.springframework.stereotype.Controller;

import com.avvarga.popaballoon.services.UserService;

@Controller
public class UserController {
	
	private UserService uServ;
	public UserController (UserService uServ) {
		this.uServ = uServ;
	}
}
