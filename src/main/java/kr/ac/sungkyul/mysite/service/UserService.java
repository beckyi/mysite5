package kr.ac.sungkyul.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.sungkyul.mysite.dao.UsersDao;
import kr.ac.sungkyul.mysite.exception.UserInfoUpdateException;
import kr.ac.sungkyul.mysite.vo.UsersVo;

@Service
public class UserService {
	
	@Autowired 	//자동 조인?
	private UsersDao usersdao;
	
	public void join(UsersVo vo){
		usersdao.insert(vo);
	}
	
	public UsersVo get(Long no){	//회원정보 수정 시 정보 출력
		UsersVo uservo = usersdao.get(no);
		return uservo;
	}
	
	public void update(UsersVo vo){
		usersdao.update(vo);
	}
	
	public UsersVo login(String email, String password){
		UsersVo authUser = usersdao.get(email,password);
		return authUser;
	}
	
	public void updateInfo(UsersVo vo){
		try {
			usersdao.update(vo);
		} catch (UserInfoUpdateException e) {
			e.printStackTrace();
		}
	}
}
