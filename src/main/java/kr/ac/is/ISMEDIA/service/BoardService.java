package kr.ac.is.ISMEDIA.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.ac.is.ISMEDIA.dao.BoardDao;
import kr.ac.is.ISMEDIA.vo.AttachFileVo;
import kr.ac.is.ISMEDIA.vo.BoardVo;

@Service
public class BoardService {
	
	private static final int LIST_PAGESIZE = 10; 
	private static final int LIST_BLOCKSIZE = 5; 
	
	@Autowired
	private BoardDao boarddao;
	
	//게시판 리스트
	public Map<String,Object> list(String spage,String keyword){
		
		int page = Integer.parseInt(spage);
		
		int totalCount = boarddao.getTotalCount();
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
		
		List<BoardVo> list = boarddao.getList(page,LIST_PAGESIZE,keyword);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sizeList", LIST_PAGESIZE);
		map.put("firstPage", startPage);
		map.put("lastPage", endPage);
		map.put("prevPage", prevPage);
		map.put("nextPage", nextPage);
		map.put("currentPage", page);
		map.put("pageCount", pageCount);
		map.put("list", list);
		map.put("totalCount", totalCount);
		map.put("keyword", keyword);
		map.put("nexttoPage", nexttoPage);
		map.put("prevtoPage", prevtoPage);
		
		return map;
	}
	

	//게시판 글쓰기
	public void write(BoardVo vo,MultipartFile file,MultipartHttpServletRequest mtfRequest) throws Exception{
		
		List<MultipartFile> fileList = mtfRequest.getFiles("file");
		
		String path = "C:\\Users\\최형민\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\ISMEDIA\\assets\\images\\test";
		
		Long no=boarddao.insert(vo);
		BoardVo vo1 = boarddao.get(no);
		
		int groupno = vo1.getGroupNo();
		int orderno = vo1.getOrderNo();
		
		for (MultipartFile mf : fileList) {
			
			String orgname=mf.getOriginalFilename();	
			long filesize =mf.getSize();
			String savename=UUID.randomUUID().toString()+"_"+orgname;
			
			AttachFileVo attachFileVo = new AttachFileVo();
			attachFileVo.setNo(no);
			attachFileVo.setPath(path);
			attachFileVo.setOrgname(orgname);
			attachFileVo.setFilesize(filesize);
			attachFileVo.setSavename(savename);
			attachFileVo.setGroupno(groupno);
			attachFileVo.setOrderno(orderno);
			
			boarddao.insertAttachFile(attachFileVo);
			
			File target = new File(path,savename);
			FileCopyUtils.copy(file.getBytes(), target);
			
		}
		
	}
	
	// 게시물 보기 [게시물 헤더정보]
	public BoardVo boardinfo(Long no) {
		
		BoardVo vo = boarddao.boardinfo(no);
		return vo;
	}
	
	// 게시물 보기 [게시물 상세정보]
	public List<AttachFileVo> attachinfo(Long no) {
		
		List<AttachFileVo> attachfilevo = boarddao.attachinfo(no);
		return attachfilevo;
	}
	
	//게시물 보기 [조회수 증가]
	public void viewcountup(Long no) {
		
		boarddao.viewcountup(no);
		
	}
	
	
}
