package kr.ac.sungkyul.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.sungkyul.mysite.dao.GuestbookDao;
import kr.ac.sungkyul.mysite.vo.GuestbookVo;

@Service
public class GuestbookService {
	
	@Autowired 	//자동 조인?
	private GuestbookDao guestbookdao;
	
	public List<GuestbookVo> list(){
		List<GuestbookVo> glist = guestbookdao.getList();
		return glist;
	}
	
//	public void insert(){
//		
//		return glist;
//	}
}
