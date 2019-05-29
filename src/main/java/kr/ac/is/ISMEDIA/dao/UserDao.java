package kr.ac.is.ISMEDIA.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.is.ISMEDIA.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;
	
	
	public UserVo login(String id,String password) {
		
		UserVo uservo = new UserVo();
		uservo.setId(id);
		uservo.setPassword(password);
		
		UserVo vo = sqlSession.selectOne("user.login",uservo);
		
		System.out.println("Dao :"+ vo);
		
		return vo;
		
	}
	

}