package kr.ac.is.ISMEDIA.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.is.ISMEDIA.service.LongStockService;

@Controller
@RequestMapping("/longstock")
public class LongStockController {
	
	@Autowired
	LongStockService longstockservice;
	
	@RequestMapping("list")
	public String LongStocklist(
			Model model,
			@RequestParam(value="kwd",required=false, defaultValue="") String keyword,
			@RequestParam(value="p",required=true,defaultValue="1") String Page){
		
		Map<String,Object> longSearch = longstockservice.list(Page,keyword);
		model.addAttribute("longstock",longSearch);
		
		return "/Main_Page/LongStock";
	}
	
	
	@RequestMapping("graph")
	public String LongStockGraph(Model model,@RequestParam(value="kwd",required=false, defaultValue="") String keyword) {
		
		Map<String,Object> longGraph = longstockservice.Graph(keyword);
		model.addAttribute("longGraph",longGraph);
		
		return "/Main_Page/LongGraph";
	}
	
	/* 전체조회 Ajax */
	@ResponseBody
	@RequestMapping(value = "radioTotal", method = RequestMethod.POST)
	public String RadioTotalList(String keyword) {
		
		String result="true";
		return result;
	}
	
	/* 그래프 Ajax */
	@ResponseBody
	@RequestMapping(value = "radioGraph", method = RequestMethod.POST)
	public String radioGraph(){
		
		String result="true";
		return result;
	}
	
	
}
