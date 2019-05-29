package kr.ac.is.ISMEDIA.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.is.ISMEDIA.service.UserService;
import kr.ac.is.ISMEDIA.vo.UserVo;

@Controller
public class MainController {
	
	@RequestMapping("/main")
	public String Main() {
		
		return "/Main_Page/Main";
	}
	
	@Autowired 
	private UserService userservice;
	
	
	@ResponseBody
	@RequestMapping(value = "checkLogin", method = RequestMethod.POST)
	public String checkID(String id,String password, HttpSession session) {
		
		UserVo authUser =  userservice.login(id,  password);

		String result = "true";
		
		if(authUser == null){
			result = "false";
		}
		else {
			session.setAttribute("authUser",authUser);
			result = "true";
		}
		return result;
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("authUser");
		session.invalidate();	
		
		return "redirect:/main";
	}

}
