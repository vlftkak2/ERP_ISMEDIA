package kr.ac.is.ISMEDIA.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import kr.ac.is.ISMEDIA.service.BomService;
import kr.ac.is.ISMEDIA.vo.BomCsvVo;

@Controller
@RequestMapping("/bom")
public class BomController {
	
	@Autowired
	BomService bomservice;
	
	/* ������Ʈ ����Ʈ */
	@RequestMapping("pjtlist")
	public String Projectlist(
			Model model,
			@RequestParam(value="kwd",required=false, defaultValue="") String keyword,
			@RequestParam(value="p",required=true,defaultValue="1") String Page){
		
		Map<String,Object> pjtlist = bomservice.Pjtlist(Page,keyword);
		model.addAttribute("pjtlist",pjtlist);
		
		return "/Main_Page/BomPjt";
	}
	
	/* BOM ����Ʈ */
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
	
	/* BOM CSV �ٿ�ε� */
	@RequestMapping(value = "/downloadCSV", method = RequestMethod.GET)
	public void downloadCSV(HttpServletResponse response,@RequestParam(value="date",defaultValue="") String date,
			@RequestParam(value="pjtno",required=false, defaultValue="") String pjtno,
			@RequestParam(value="itemcd",required=false, defaultValue="") String itemcd) throws Exception {
		
		List<BomCsvVo> Csvlist = bomservice.Csvlist(pjtno,itemcd);  
		String filename="Bom����Ʈ.csv";
		response.setContentType("text/csv; charset=EUC-KR");
		
		response.setHeader("Content-Disposition", "filename="+new String(filename.getBytes("euc-kr"),"8859_1"));
		
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),CsvPreference.STANDARD_PREFERENCE);
		
		String[] header = {"����","��ǰ���ڵ�","��ǰ���","��ǰ���ڵ�","ǰ���","�԰�","��Ű��","����Ŀ","reference","����","ǥ�ؿ���","�ҿ����","ȭ��","�ܰ�","�ݾ�","�ŷ�ó"};
		csvWriter.writeHeader(header);
		
		for(BomCsvVo vo : Csvlist) {
			csvWriter.write(vo, header);
		}
		csvWriter.close();
	}
	
	
}
