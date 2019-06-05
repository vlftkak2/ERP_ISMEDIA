package kr.ac.is.ISMEDIA.controller;

import java.awt.print.Book;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.ArrayList;
import java.awt.List; 

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.CsvMapWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import kr.ac.is.ISMEDIA.service.LongStockService;
import kr.ac.is.ISMEDIA.vo.LongStockVo;

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
	
	
	 @RequestMapping(value = "/downloadCSV")
	    public void downloadCSV(HttpServletResponse response) throws IOException {
	
	        String csvFileName = "books.csv";
	 
	        response.setContentType("text/csv");
	 
	        // creates mock data
	        String headerKey = "Content-Disposition";
	        String headerValue = String.format("attachment; filename=\"%s\"",
	                csvFileName);
	        response.setHeader(headerKey, headerValue);
	        
	        List<LongStockVo> CsvList = longstockservice.Csvlist();
	        
	 
	        // uses the Super CSV API to generate CSV data from the model data
	        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
	                CsvPreference.STANDARD_PREFERENCE);
	 
	        String[] header = { "Title", "Description", "Author", "Publisher",
	                "isbn", "PublishedDate", "Price" };
	 
	        csvWriter.writeHeader(header);
	 
	        for (LongStockVo longstock : CsvList) {
	            csvWriter.write(longstock, header);
	        }
	 
	        csvWriter.close();
	    }

}
