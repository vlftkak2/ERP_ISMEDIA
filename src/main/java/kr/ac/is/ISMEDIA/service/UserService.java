package kr.ac.is.ISMEDIA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.ac.is.ISMEDIA.dao.UserDao;
import kr.ac.is.ISMEDIA.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userdao;
	
	
	public UserVo login(String id,String password) {
		
		UserVo authUser = userdao.login(id,password);
		return authUser;
	}

	

}
