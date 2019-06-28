package kr.ac.is.ISMEDIA.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.is.ISMEDIA.dao.BomDao;
import kr.ac.is.ISMEDIA.dao.LongStockDao;
import kr.ac.is.ISMEDIA.vo.BomVo;
import kr.ac.is.ISMEDIA.vo.LongStockVo;
import kr.ac.is.ISMEDIA.vo.ProjectVo;

@Service
public class BomService {
	
	private static final int LIST_PAGESIZE = 10; 
	private static final int LIST_BLOCKSIZE = 5; 
	
	@Autowired
	private BomDao bomdao;
	
	/* 프로젝트 List */
	public Map<String, Object> Pjtlist(String spage, String keyword) {

		int totalCount;
		
		if (keyword == null || "".equals(keyword)) {
			totalCount=bomdao.getTotalCount(keyword);
		}else {
			totalCount=bomdao.getTotalSearchCount(keyword);
		}
		
		int page = Integer.parseInt(spage);
		int pageCount = (int) Math.ceil((double) totalCount / LIST_PAGESIZE);
		int blockCount = (int) Math.ceil((double) pageCount / LIST_BLOCKSIZE);
		int currentBlock = (int) Math.ceil((double) page / LIST_BLOCKSIZE);
		
		if (page < 1) {
			page = 1;
			currentBlock = 1;
		} else if (page > pageCount) {
			page = pageCount;
			currentBlock = (int) Math.ceil((double) page / LIST_BLOCKSIZE);
		}		
			
		int startPage = (currentBlock - 1) * LIST_BLOCKSIZE + 1;
		int endPage = (startPage - 1) + LIST_BLOCKSIZE;
		int prevPage = (page >= startPage) ? (page-1) : (currentBlock - 1) * LIST_BLOCKSIZE;
		int nextPage = (page <= endPage) ? (page+1) : currentBlock * LIST_BLOCKSIZE + 1;
		int nexttoPage = (currentBlock < blockCount) ? currentBlock * LIST_BLOCKSIZE + 1 : page;
		int prevtoPage = (currentBlock > 1) ? startPage-5  : page;

		List<ProjectVo> list = bomdao.getList(page,LIST_PAGESIZE,keyword);
		
		Map<String, Object> pjtSearch = new HashMap<String, Object>();
		pjtSearch.put("sizeList", LIST_PAGESIZE);
		pjtSearch.put("firstPage", startPage);
		pjtSearch.put("lastPage", endPage);
		pjtSearch.put("prevPage", prevPage);
		pjtSearch.put("nextPage", nextPage);
		pjtSearch.put("currentPage", page);
		pjtSearch.put("pageCount", pageCount);
		pjtSearch.put("list", list);
		pjtSearch.put("totalCount", totalCount);
		pjtSearch.put("keyword", keyword);
		pjtSearch.put("nexttoPage", nexttoPage);
		pjtSearch.put("prevtoPage", prevtoPage);
		
		return pjtSearch;
	}
	
	/* BOM List */
	public Map<String, Object> bomlist(String spage, String pjtno, String itemcd) {

		int totalCount=bomdao.bomgetcount(itemcd);
		
		int page = Integer.parseInt(spage);
		int pageCount = (int) Math.ceil((double) totalCount / LIST_PAGESIZE);
		int blockCount = (int) Math.ceil((double) pageCount / LIST_BLOCKSIZE);
		int currentBlock = (int) Math.ceil((double) page / LIST_BLOCKSIZE);
		
		if (page < 1) {
			page = 1;
			currentBlock = 1;
		} else if (page > pageCount) {
			page = pageCount;
			currentBlock = (int) Math.ceil((double) page / LIST_BLOCKSIZE);
		}		
			
		int startPage = (currentBlock - 1) * LIST_BLOCKSIZE + 1;
		int endPage = (startPage - 1) + LIST_BLOCKSIZE;
		int prevPage = (page >= startPage) ? (page-1) : (currentBlock - 1) * LIST_BLOCKSIZE;
		int nextPage = (page <= endPage) ? (page+1) : currentBlock * LIST_BLOCKSIZE + 1;
		int nexttoPage = (currentBlock < blockCount) ? currentBlock * LIST_BLOCKSIZE + 1 : page;
		int prevtoPage = (currentBlock > 1) ? startPage-5  : page;

		List<BomVo> bomlist = bomdao.bomgetList(page,LIST_PAGESIZE,pjtno,itemcd);
		
		Map<String, Object> mpbomlist = new HashMap<String, Object>();
		mpbomlist.put("sizeList", LIST_PAGESIZE);
		mpbomlist.put("firstPage", startPage);
		mpbomlist.put("lastPage", endPage);
		mpbomlist.put("prevPage", prevPage);
		mpbomlist.put("nextPage", nextPage);
		mpbomlist.put("currentPage", page);
		mpbomlist.put("pageCount", pageCount);
		mpbomlist.put("bomlist", bomlist);
		mpbomlist.put("totalCount", totalCount);
		mpbomlist.put("pjtno", pjtno);
		mpbomlist.put("itemcd", itemcd);
		mpbomlist.put("nexttoPage", nexttoPage);
		mpbomlist.put("prevtoPage", prevtoPage);
		
		return mpbomlist;
	}

}
