package kr.ac.is.ISMEDIA.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.is.ISMEDIA.vo.BomCsvVo;
import kr.ac.is.ISMEDIA.vo.BomVo;
import kr.ac.is.ISMEDIA.vo.ProjectVo;


@Repository
public class BomDao {
	
	@Autowired
	private SqlSession sqlSession;
	
		//Bom 프로젝트 조회
		public List<ProjectVo> getList(int page,int pagesize,String keyword) {

			Map<String, Object> ProjectSearch = new HashMap<>();

				if (keyword == null || "".equals(keyword)) {
					ProjectSearch.put("page_start", (page - 1) * pagesize + 1);
					ProjectSearch.put("page_end", page * pagesize);
				
				List<ProjectVo> Pjtlist = sqlSession.selectList("project.getList", ProjectSearch);
				return Pjtlist;
				
			} else {
			
			ProjectSearch.put("keyword", "%"+keyword+"%");
			ProjectSearch.put("page_start", (page - 1) * pagesize + 1);
			ProjectSearch.put("page_end", page * pagesize);
			List<ProjectVo> Pjtlist = sqlSession.selectList("project.projectListKeyword", ProjectSearch);
			
			return Pjtlist;
			}
			
		}
		
		// 프로젝트 게시물 총 수
		public int getTotalCount(String keyword) {
			Map<String, Object> count = new HashMap<>();
			count.put("keyword", keyword);
			
			int totalCount = sqlSession.selectOne("project.getTotalCount",count);
			return totalCount;
			
		}
		
		// 프로젝트 검색 총 수
		public int getTotalSearchCount(String keyword) {
			
			Map<String, Object> count = new HashMap<>();
			count.put("keyword", "%"+keyword+"%");
			
			int totalCount = sqlSession.selectOne("project.getTotalSearchCount",count);
			return totalCount;
		}
		
		
		//Bom리스트 조회
		public List<BomVo> bomgetList(int page,int pagesize,String pjtno,String itemcd) {

			Map<String, Object> BomList = new HashMap<>();
			
			BomList.put("page_start", (page - 1) * pagesize + 1);
			BomList.put("page_end", page * pagesize);
			BomList.put("pjtno", pjtno);
			BomList.put("itemcd", itemcd);
			
			List<BomVo> BomVolist = sqlSession.selectList("bom.bomList", BomList);
			return BomVolist;
			
		}
		
		// bom 검색 총 수
		public int bomgetcount(String itemcd) {
			
			Map<String, Object> count = new HashMap<>();
			count.put("itemcd", itemcd);
			int totalCount = sqlSession.selectOne("bom.getCount",count);
			
			return totalCount;
		}
		
		/* BOM CSV 다운로드 */
		public List<BomCsvVo> Csvlist(String pjtno,String itemcd){
			
			Map<String, Object> CsvKeyword = new HashMap<>();
			CsvKeyword.put("pjtno", pjtno);
			CsvKeyword.put("itemcd", itemcd);
			
			List<BomCsvVo> Csvlist = sqlSession.selectList("bom.Csvlist",CsvKeyword);
			return Csvlist;
		}

}
