package kr.ac.is.ISMEDIA.controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.ac.is.ISMEDIA.service.BoardService;
import kr.ac.is.ISMEDIA.vo.AttachFileVo;
import kr.ac.is.ISMEDIA.vo.BoardVo;
import kr.ac.is.ISMEDIA.vo.UserVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService boardservice;
	
	//게시판 리스트
	@RequestMapping("/list")
	public String list(Model model, @RequestParam(value = "p", required = true, defaultValue = "1") String page,
			@RequestParam(value = "kwd", required = false, defaultValue = "") String keyword)
	{
	  Map<String,Object> map=boardservice.list(page,keyword);
	  model.addAttribute("map",map);
	  
	  return "Main_Page/Board";
	}
	
	//게시판 글쓰기 폼
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String writeform(HttpSession session) {
		
		if(session==null) {
			return "redirect:/main";
		}
		return "/Main_Page/Board_write";
	}
	
	//게시판 글쓰기
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String write(@ModelAttribute BoardVo vo, HttpSession session, MultipartFile file,MultipartHttpServletRequest mtfRequest) throws Exception {
		
		if(session==null) {
			return "redirect:/main";
		}
		
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if(authUser==null) {
			return "redirect:/main";
		}
		
		vo.setUserid(authUser.getId());
		vo.setUsername(authUser.getName());
		
		boardservice.write(vo,file,mtfRequest);
		
		return "redirect:/board/list";
		
	}
	
	//게시판 글보기 폼
	@RequestMapping(value="/viewform")
	public String viewform(HttpSession session, 
			@RequestParam(value="no",required=false,defaultValue="1") Long no,
			@RequestParam(value="groupNo") Integer groupNo,
			Model model) {
		
		if(session==null) {
			return "redirect:/main";
		}
		
		BoardVo vo = boardservice.boardinfo(no);
		List<AttachFileVo> attachfilevo = boardservice.attachinfo(no);
		
		boardservice.viewcountup(no);
		
		return null;
		
	}
	
	
}
