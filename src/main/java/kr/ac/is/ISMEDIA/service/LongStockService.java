package kr.ac.is.ISMEDIA.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.ac.is.ISMEDIA.dao.LongStockDao;
import kr.ac.is.ISMEDIA.vo.LongStockVo;

@Service
public class LongStockService {
	
	private static final int LIST_PAGESIZE = 10; 
	private static final int LIST_BLOCKSIZE = 5; 
	
	@Autowired
	private LongStockDao longstockdao;
	
	/* 장기재고 List */
	public Map<String, Object> list(String spage, String keyword) {
		
		int page = Integer.parseInt(spage);
		
		int totalCount = longstockdao.getTotalCount(keyword);
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
		
		List<LongStockVo> list = longstockdao.getList(page,LIST_PAGESIZE,keyword);
		
		Map<String, Object> longSearch = new HashMap<String, Object>();
		longSearch.put("sizeList", LIST_PAGESIZE);
		longSearch.put("firstPage", startPage);
		longSearch.put("lastPage", endPage);
		longSearch.put("prevPage", prevPage);
		longSearch.put("nextPage", nextPage);
		longSearch.put("currentPage", page);
		longSearch.put("pageCount", pageCount);
		longSearch.put("list", list);
		longSearch.put("totalCount", totalCount);
		longSearch.put("keyword", keyword);
		longSearch.put("nexttoPage", nexttoPage);
		longSearch.put("prevtoPage", prevtoPage);
		
		return longSearch;
	}
	
	/* 장기재고 Graph */
	public Map<String, Object> Graph(String keyword) {
		
		List<LongStockVo> Graph = longstockdao.Graph(keyword);
		List<LongStockVo> HighGraph = longstockdao.HighGraph(keyword);
		List<LongStockVo> RowGraph = longstockdao.RowGraph(keyword);
		
		Map<String, Object> longGraph = new HashMap<String, Object>();
		longGraph.put("Graph", Graph);
		longGraph.put("HighGraph", HighGraph);
		longGraph.put("RowGraph", RowGraph);

		longGraph.put("keyword", keyword);
		
		return longGraph;
		
	}
	

}
