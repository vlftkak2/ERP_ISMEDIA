package kr.ac.is.ISMEDIA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/main")
	public String main() {
		return "/Main_Page/Main";
	}
	

}
