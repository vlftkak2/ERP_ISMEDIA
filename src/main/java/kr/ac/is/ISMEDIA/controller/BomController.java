package kr.ac.is.ISMEDIA.controller;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import kr.ac.is.ISMEDIA.service.BomService;
import kr.ac.is.ISMEDIA.vo.BomCsvVo;
import kr.ac.is.ISMEDIA.vo.FileVersionVo;

@Controller
@RequestMapping("/bom")
public class BomController {
	
	@Autowired
	BomService bomservice;
	
	/* 프로젝트 리스트 */
	@RequestMapping("pjtlist")
	public String Projectlist(
			Model model,
			@RequestParam(value="kwd",required=false, defaultValue="") String keyword,
			@RequestParam(value="p",required=true,defaultValue="1") String Page){
		
		Map<String,Object> pjtlist = bomservice.Pjtlist(Page,keyword);
		model.addAttribute("pjtlist",pjtlist);
		
		return "/Main_Page/BomPjt";
	}
	
	/* BOM 리스트 */
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
	
	/* BOM CSV 다운로드 */
	@RequestMapping(value = "/downloadCSV", method = RequestMethod.GET)
	public void downloadCSV(HttpServletResponse response,@RequestParam(value="date",defaultValue="") String date,
			@RequestParam(value="pjtno",required=false, defaultValue="") String pjtno,
			@RequestParam(value="itemcd",required=false, defaultValue="") String itemcd) throws Exception {
		
		List<BomCsvVo> Csvlist = bomservice.Csvlist(pjtno,itemcd);  
		String filename="Bom리스트.csv";
		response.setContentType("text/csv; charset=EUC-KR");
		
		response.setHeader("Content-Disposition", "filename="+new String(filename.getBytes("euc-kr"),"8859_1"));
		
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),CsvPreference.STANDARD_PREFERENCE);
		
		String[] header = {"순서","모품목코드","모품목명","자품목코드","품목명","규격","패키지","메이커","reference","레벨","표준원수","소요원수","화폐","단가","금액","거래처"};
		csvWriter.writeHeader(header);
		
		for(BomCsvVo vo : Csvlist) {
			csvWriter.write(vo, header);
		}
		csvWriter.close();
	}
	
	/* SVN다운로드 */
	@RequestMapping(value = "/SVN", method = RequestMethod.GET)
	public void downloadSVN(HttpServletResponse response) throws Exception {
		
		FileVersionVo filevo = bomservice.versionpath(); 

		String filepath = filevo.getPath();
		String filename = filevo.getFilename();
		
		response.setContentType("application/download");
		response.setHeader("Content-disposition", "attachment; filename=\"" + URLEncoder.encode(filename,"UTF-8") +"\"");
		OutputStream resOut = response.getOutputStream();
		
		FileInputStream fin = new FileInputStream(filepath);
		FileCopyUtils.copy(fin, resOut);
			
		fin.close();
		
		
		
	}
	
	
}
