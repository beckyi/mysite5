package kr.ac.sungkyul.mysite.dao;

//import java.util.HashMap;
//import java.util.Map;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import kr.ac.sungkyul.mysite.exception.UserInfoUpdateException;
import kr.ac.sungkyul.mysite.vo.UsersVo;

@Repository
public class UsersDao {
	
	@Autowired
	private SqlSession sqlSession;	//db연결
	
//	@Autowired
//	private DataSource dataSource;	//인터페이스(오라클구현)
	   
	   public void insert(UsersVo vo) {
	     int count = sqlSession.insert("user.insert",vo);
	     System.out.println(count);
	   }
	   
	   public UsersVo get(String email, String password) {
		   UsersVo usersvo = new UsersVo();
		   usersvo.setEmail(email);
		   usersvo.setPassword(password);
		   UsersVo vo = sqlSession.selectOne("user.getByEmailAndPassword",usersvo);
		   
		   //만약에 피라미터로 넘겨야 할 매핑 클래스가 없는 경우
//		   Map<String, Object> map = new HashMap<String, Object>();
//		   map.put("email",email);
//		   map.put("password",password);
//		   
//		   UsersVo uvo = sqlSession.selectOne("user.getByEmailAndPassword",map);
		   
		   return vo;
	   }
	   
	   public UsersVo get(Long userNo){
		   UsersVo vo = sqlSession.selectOne("user.getByNo",userNo);
		   
		   return vo;
	   }
	   
	   public void update(UsersVo vo){
		   System.out.println(vo);
		   sqlSession.update("user.update",vo);
	   }
	   
	   public UsersVo get(String email){
		   UsersVo vo = sqlSession.selectOne("user.getByEmail",email);
		   
		   return vo;
	   }
}
