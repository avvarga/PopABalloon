package com.avvarga.popaballoon.controllers;

import java.security.Principal;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import com.avvarga.popaballoon.models.User;
import com.avvarga.popaballoon.services.UserService;

@Controller
public class UserController {
	
	private UserService uServ;
	public UserController (UserService uServ) {
		this.uServ = uServ;
	}
	
	
	@RequestMapping("/")
	public String main(HttpServletRequest request) {
		SecurityContextHolder.getContext().setAuthentication(null);
		return "index.jsp";
	}
	
	@RequestMapping("/test")
	public String test(Model model) {
		model.addAttribute("users", uServ.findAll());
		return "test.jsp";
	}
	//Admin
	@RequestMapping("/admin")
    public String adminPage() {
        return "Admin.jsp";
    }
	
	@RequestMapping("/validate")
	@ResponseBody
	public String validate(@RequestParam("login") String login, @RequestParam("code") String code, HttpServletRequest request) {
		try {
			request.login(login, code);
		} catch (ServletException e) {
			System.out.println(e);
			return "Error"; 
		}
		return "Granted";
		
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
