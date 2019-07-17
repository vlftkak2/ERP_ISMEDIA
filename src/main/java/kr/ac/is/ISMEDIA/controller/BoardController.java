package kr.ac.is.ISMEDIA.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import kr.ac.is.ISMEDIA.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService customservice;
	
	//게시판 리스트
	@RequestMapping("/list")
	public String list(Model model, @RequestParam(value = "p", required = true, defaultValue = "1") String page,
			@RequestParam(value = "kwd", required = false, defaultValue = "") String keyword)
	{
	  Map<String,Object> map=customservice.list(page,keyword);
	  model.addAttribute("map",map);
	  
	  return "Main_Page/Board";
	}
	
	//게시판 글쓰기
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String writeform(HttpSession session) {
		
		if(session==null) {
			return "redirect:/main";
		}
		return "/Main_Page/Board_write";
	}
	
}
