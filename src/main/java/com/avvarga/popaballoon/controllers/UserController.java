package com.avvarga.popaballoon.controllers;

import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.avvarga.popaballoon.models.User;
import com.avvarga.popaballoon.services.UserService;

@Controller
public class UserController {
	
	private UserService uServ;
	public UserController (UserService uServ) {
		this.uServ = uServ;
	}
	
	
	@RequestMapping("/")
	public String main() {
		return "index.jsp";
	}
	
	@RequestMapping("/test")
	public String test() {
		return "test.jsp";
	}
	
	@RequestMapping("/validate")
	public String validate(@RequestParam("login") String login, @RequestParam("code") String code, HttpServletRequest request) {
		try {
			request.login(login, code);
		} catch (ServletException e) {
			System.out.println("Errors");
			return "redirect:/"; 
		}
		System.out.println("you have entered");
		return "redirect:/";
		
	}
	
	//Generate a code 
	@PostMapping("/test/generate")
	public String genCode(@RequestParam("login") String login,  Model model) {
		//Generates a Random String 
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 9) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        model.addAttribute("code",saltStr);
        //Creates the user
        User nUser =  new User();
        nUser.setLogin(login);
        nUser.setCode(saltStr);
        System.out.println(saltStr);
        //Saves the user to the DB
        uServ.saveWithUserRole(nUser);
		return "redirect:/test";
	}
	
}
