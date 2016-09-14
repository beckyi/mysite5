package kr.ac.sungkyul.mysite.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.sungkyul.mysite.dao.BBSDao;
import kr.ac.sungkyul.mysite.vo.AttachFileVo;
import kr.ac.sungkyul.mysite.vo.BBSVo;

@Service	
public class BBSService {
	
	@Autowired
	private BBSDao bbsDao;
	
	@Transactional
	public void insertBoard(BBSVo bbsVo, MultipartFile file) throws IOException{
		
		//2. no - 게시글 저장 후 글 no 가져옴
		Long no = bbsDao.insertBoard(bbsVo);
		System.out.println("no : " + no);
		//1. fno: 저장할때
		
		//3.orgName 
		String orgName= file.getOriginalFilename();
		
		//4.fileSize 
		Long fileSize = file.getSize();
		
		//5.saveName 
		String saveName = UUID.randomUUID().toString()+"-"+orgName;
		
		//6.path
		String path="c:\\upload";
		
		AttachFileVo attachFileVo = new AttachFileVo();
		attachFileVo.setNo(no);
		attachFileVo.setPath(path);
		attachFileVo.setOrgName(orgName);
		attachFileVo.setSaveName(saveName);
		attachFileVo.setFileSize(fileSize);
		
		System.out.println(attachFileVo.toString());
//		System.out.println("service: "+bbsVo.toString());
		bbsDao.insertAttachFile(attachFileVo);
		
		File target = new File(path,saveName);
		FileCopyUtils.copy(file.getBytes(), target);
	}
	
	 public AttachFileVo selectAttachFileByNo(Long no) {
	      AttachFileVo attachFileVo = bbsDao.selectAttachFileByNo(no);
	      return attachFileVo;
	   }
	 
	 public AttachFileVo selectAttachFileByFNO (Long fno) {
//		 System.out.println("2");
	      AttachFileVo attachFileVo = bbsDao.selectAttachFileByFNo(fno);
	      return attachFileVo;
	   }

	
	public List<BBSVo> listBoard(){
		List<BBSVo> listBoard = bbsDao.listBoard();
	    return listBoard;
	}
	
	public BBSVo readBoard(Long no){
		BBSVo readBoard = bbsDao.readBoard(no);
	    return readBoard;
	}
}
