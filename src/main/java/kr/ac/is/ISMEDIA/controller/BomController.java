package kr.ac.is.ISMEDIA.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.is.ISMEDIA.service.BomService;

@Controller
@RequestMapping("/bom")
public class BomController {
	
	@Autowired
	BomService bomservice;
	
	@RequestMapping("pjtlist")
	public String Projectlist(
			Model model,
			@RequestParam(value="kwd",required=false, defaultValue="") String keyword,
			@RequestParam(value="p",required=true,defaultValue="1") String Page){
		
		Map<String,Object> pjtlist = bomservice.Pjtlist(Page,keyword);
		model.addAttribute("pjtlist",pjtlist);
		
		return "/Main_Page/BomPjt";
	}
	
	@RequestMapping("bomlist")
	public String Bomlist(
			Model model,
			@RequestParam(value="pjtno",required=false, defaultValue="") String pjtno,
			@RequestParam(value="itemcd",required=false, defaultValue="") String itemcd,
			@RequestParam(value="p",required=true,defaultValue="1") String Page){
		
		
		Map<String,Object> mpbomlist = bomservice.bomlist(Page,pjtno,itemcd);
		model.addAttribute("mpbomlist",mpbomlist);
		
		return "/Main_Page/Bomlist";
	}
	
}
