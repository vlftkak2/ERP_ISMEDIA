package kr.ac.is.ISMEDIA.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.is.ISMEDIA.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardVo> getList(int page, int pagesize, String keyword) { 
		Map<String, Object> map=new HashMap<>();

		if (keyword == null || "".equals(keyword)) {

			map.put("page_start", (page - 1) * pagesize + 1);
			map.put("page_end", page * pagesize);
			
			List<BoardVo> list=sqlSession.selectList("board.getList",map);
			return list;
			
		} else {
			map.put("keyword", "%" + keyword + "%");
			map.put("page_start", (page - 1) * pagesize + 1);
			map.put("page_end", page * pagesize);
			
			List<BoardVo> list=sqlSession.selectList("board.getListKeyword",map);
			return list;
		}
	}
	
	//°Ô½Ã¹° ÃÑ¼ö
	public int getTotalCount() {
		return sqlSession.selectOne("board.totalCount");
	}

}
