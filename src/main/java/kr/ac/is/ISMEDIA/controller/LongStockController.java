package kr.ac.is.ISMEDIA.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random; 
import java.io.IOException;
import java.util.List; 


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
import kr.ac.is.ISMEDIA.vo.LongStockCsvVo;

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
		
		System.out.println("keyword : "+keyword);
		
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
	
		    
	/* ��ü��ȸ Ajax */
	@ResponseBody
	@RequestMapping(value = "radioTotal", method = RequestMethod.POST)
	public String RadioTotalList(String keyword) {
		
		String result="true";
		return result;
	}
	
	/* �׷��� Ajax */
	@ResponseBody
	@RequestMapping(value = "radioGraph", method = RequestMethod.POST)
	public String radioGraph(){
		
		String result="true";
		return result;
	}
	
	
	/* CSV���� �ٿ�ε� */
	@RequestMapping(value = "/downloadCSV", method = RequestMethod.GET)
	public void downloadCSV(HttpServletResponse response,@RequestParam(value="date",defaultValue="") String date,
			@RequestParam(value="csv",required=false, defaultValue="") String keyword) throws Exception {
		
		List<LongStockCsvVo> Csvlist = longstockservice.Csvlist(keyword);  
		String filename=keyword+" ��������Ȳ.csv";
		response.setContentType("text/csv; charset=EUC-KR");
		
		//String headerKey="Content-Disposition";
		//String headerValue=String.format("attachment; filename=\"%s\"",filename);		
		//response.setHeader(headerKey, headerValue);
		
		response.setHeader("Content-Disposition", "filename="+new String(filename.getBytes("euc-kr"),"8859_1"));
		
		System.out.println("keyword : "+keyword);
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),CsvPreference.STANDARD_PREFERENCE);
		
		String[] header = {"���ؿ�","��","ǰ���ڵ�","ǰ���","�԰�","�԰����","����","���","���","ǰ���",
						"ǰ�����","�ܰ�","�ݾ�","���","����","�ʰ��ϼ�"};
		csvWriter.writeHeader(header);
		
		for(LongStockCsvVo vo : Csvlist) {
			csvWriter.write(vo, header);
		}
		csvWriter.close();
	}

}
