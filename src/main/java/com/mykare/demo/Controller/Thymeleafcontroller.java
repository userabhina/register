package com.mykare.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mykare.demo.entity.User;
import com.mykare.demo.service.UserService;

@Controller
public class Thymeleafcontroller {
   
	@Autowired
    private UserService userService;

    @GetMapping("/")
    public String gethome(User user) {
    	return "home" ;
    }
    
    @GetMapping("/user")
    public String getUserList(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
    	return "userlist" ;
    }


	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}

