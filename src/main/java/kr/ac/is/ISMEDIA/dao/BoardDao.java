package kr.ac.is.ISMEDIA.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.is.ISMEDIA.vo.AttachFileVo;
import kr.ac.is.ISMEDIA.vo.BoardVo;
import kr.ac.is.ISMEDIA.vo.FileVersionVo;

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
	
	//게시물 총수
	public int getTotalCount() {
		return sqlSession.selectOne("board.totalCount");
	}
	
	//게시물 쓰기
	public Long insert(BoardVo vo) {
		sqlSession.insert("board.insert",vo);
		return vo.getNo();
	}
	
	//게시물 불러오기
	public BoardVo get(Long no) {
		System.out.println("no : "+no);
		BoardVo vo = sqlSession.selectOne("board.listByNo",no);
		
		return vo;
	}
	
	//게시물 쓰기 (첨부파일참조)
	public void insertAttachFile(AttachFileVo attachFileVo) {
		System.out.println("attachFileVo : " +attachFileVo);
		sqlSession.insert("board.insertAttachFile",attachFileVo);
	}
	
	//게시물 보기 [헤더]
	public BoardVo boardinfo(Long no) {
		BoardVo vo = sqlSession.selectOne("board.boardinfo",no);
		return vo;
	}
	
	//게시물 보기 [상세]
	public List<AttachFileVo> attachinfo(Long no) {
		
		List<AttachFileVo> attachfilevo = sqlSession.selectList("board.attachinfo", no);
		return attachfilevo;
	}
	
	//게시물 보기[조회수 증가]
	public void viewcountup(Long no) {
		sqlSession.update("board.viewcountup",no);
	}
	
}
