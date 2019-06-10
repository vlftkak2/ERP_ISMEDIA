package kr.ac.is.ISMEDIA.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.is.ISMEDIA.vo.LongStockCsvVo;
import kr.ac.is.ISMEDIA.vo.LongStockVo;

@Repository
public class LongStockDao {
	
	
	@Autowired
	private SqlSession sqlSession;


	//장기재고 조회
	public List<LongStockVo> getList(int page,int pagesize,String keyword) {

		Map<String, Object> longSearch = new HashMap<>();

			if (keyword == null || "".equals(keyword)) {

				longSearch.put("page_start", (page - 1) * pagesize + 1);
				longSearch.put("page_end", page * pagesize);

			List<LongStockVo> list = sqlSession.selectList("longstock.getList", longSearch);

			return list;
			
			} else {
		
		longSearch.put("keyword", keyword);
		longSearch.put("page_start", (page - 1) * pagesize + 1);
		longSearch.put("page_end", page * pagesize);
		List<LongStockVo> list = sqlSession.selectList("longstock.longstockListKeyword", longSearch);

		return list;
		}
		
	}
	
	/* 장기재고 Graph */
	public List<LongStockVo> Graph(String keyword){
		
		Map<String, Object> longSearchGraph = new HashMap<>();
		longSearchGraph.put("keyword",keyword);
		
		List<LongStockVo> longGraph = sqlSession.selectList("longstock.Graph",longSearchGraph);
		return longGraph;
	}
	
	/* 장기재고 HighGraph */
	public List<LongStockVo> HighGraph(String keyword){
		
		Map<String, Object> longSearchGraph = new HashMap<>();
		longSearchGraph.put("keyword",keyword);
		
		List<LongStockVo> HighGraph = sqlSession.selectList("longstock.HighGraph",longSearchGraph);
		return HighGraph;
	}
	
	/* 장기재고 RowGraph */
	public List<LongStockVo> RowGraph(String keyword){
		
		Map<String, Object> longSearchGraph = new HashMap<>();
		longSearchGraph.put("keyword",keyword);
		
		List<LongStockVo> RowGraph = sqlSession.selectList("longstock.RowGraph",longSearchGraph);
		return RowGraph;
	}
	

	// 게시물 총 개수
	public int getTotalCount(String keyword) {
		
		Map<String, Object> count = new HashMap<>();
		count.put("keyword", keyword);
		
		int totalCount = sqlSession.selectOne("longstock.getTotalCount",count);
		return totalCount;
		
	}
	
	//CSV 파일 다운로드
	public List<LongStockCsvVo> Csvlist(String keyword){
		
		Map<String, Object> CsvKeyword = new HashMap<>();
		CsvKeyword.put("keyword", keyword);
		
		List<LongStockCsvVo> Csvlist = sqlSession.selectList("longstock.Csvlist",keyword);
		return Csvlist;
	}

}
