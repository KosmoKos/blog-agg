package KosmoKos.jba.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import KosmoKos.jba.entity.User;
import KosmoKos.jba.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")
	public User construct(){		
		return new User();
	}

	@RequestMapping
	public String showRegigeter(){		
		return "user-register";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String doRegigeter(@Valid @ModelAttribute("user") User user, BindingResult result){	
		if(result.hasErrors()){
			return "user-register";
		}
		userService.save(user);	
		return "redirect:/register.html?success=true";
	}
	
}
