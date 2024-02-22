package com.FBHelpdesk.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {

	@GetMapping("")
    public String index() {
        return "index";
    }
	
	@GetMapping("/login")
    public String login() {
        return "login";
    }
	
	@GetMapping("/dash")
    public String dash() {
        return "dash";
    }
	
	@GetMapping("/connect_fb_page")
    public String connect_fb_page() {
        return "connect_fb_page";
    }
	
	@GetMapping("/connect_disconnect_fb")
	public String connect_disconnect_fb() {
    return "connect_disconnect_fb";
	}
}
