package com.FBHelpdesk.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.FBHelpdesk.entity.User;
import com.FBHelpdesk.services.UserServices;

@Controller
public class UserController {
	
	@Autowired
	UserServices us;
	
	
    
 // Register
 	@PostMapping("/addUsers")
     public String addUsers(  
                              @RequestParam("name") String name,
                              @RequestParam("email") String email,
                              @RequestParam("password") String password ,Model model) {
         User user = new User();
         boolean emailExists=us.checkEmail(email);
         if(emailExists==false) {
        	 user.setName(name);
        	 user.setEmail(email);
        	 user.setPassword(password);
         us.addUsers(user);
        
         System.out.println(user);
         String result = us.addSuccess();
	        model.addAttribute("result",result);
         System.out.println("user added successfully!");
         return "index";
         }
         else {
         	String result = us.addExists();
             model.addAttribute("result", result);
         	System.out.println("user already exists!");
         	return "index";
         }
     }
 	
 // login
 	@PostMapping("/validate")
 	public String validate(@RequestParam("email") String email,
             				@RequestParam("password") String password,Model model) {
 		if(us.checkEmail(email)) {
 			
 		boolean val=us.validate(email, password);
 		//if user is valid
 		if(val==true){
 			
 			System.out.println("login successfull!");
 			return "connect_fb_page";
 			}
 		else {
 			String result = us.loginExists();
             model.addAttribute("result", result);
 			System.out.println("incorrect credentials, try again!");
 			return "login";
 		}
 		
 	}else {
 		String result = us.loginExists();
        model.addAttribute("result", result);
 			return "login";
 		}
 	}

	

}
