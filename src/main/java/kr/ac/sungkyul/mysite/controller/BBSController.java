package kr.ac.sungkyul.mysite.controller;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.sungkyul.mysite.service.BBSService;
import kr.ac.sungkyul.mysite.vo.AttachFileVo;
import kr.ac.sungkyul.mysite.vo.BBSVo;

@Controller
@RequestMapping("/bbs")
public class BBSController {
	
	@Autowired
	private BBSService bbsService;
	
	//쓰기폼
	@RequestMapping(value="write", method=RequestMethod.GET)
	public String write(){
		return "board/write";
	}
	
	//글등록
	@RequestMapping(value="register", method=RequestMethod.POST)
	public String registerBoard(BBSVo bbsVo, MultipartFile file) throws Exception{
//		System.out.println(bbsVo.toString());
//		System.out.println(file.getOriginalFilename());
		bbsService.insertBoard(bbsVo, file);
		
		return "redirect:list";
	}
	
	//리스트
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String listcard(Model model){
		List<BBSVo> listBoard = bbsService.listBoard();
//		System.out.println(listBoard.toString());
		//화면에서 넘겨준다.
		 model.addAttribute("listBoard", listBoard); //화면에서 쓸 이름, 넘겨줄 애(실제 데이터)

		return "board/list";
	}
	
	//상세 글보기
	@RequestMapping(value="view", method=RequestMethod.GET)
	public String readboard(Long no, Model model){
		
		BBSVo bbsVo = bbsService.readBoard(no);
		AttachFileVo attachFileVo = bbsService.selectAttachFileByNo(no);
//	    System.out.println(bbsVo.toString());
	    model.addAttribute("readBoardVo", bbsVo);
//	    System.out.println(attachFileVo.toString());
	    model.addAttribute("attachFileVo", attachFileVo);
	      
	    return "board/view";
	}
	
	//수정폼
	@RequestMapping(value="modifyform", method=RequestMethod.GET)
	public String modifyform(Long no, Model model){
		
		BBSVo bbsVo = bbsService.readBoard(no);
		
		model.addAttribute("Boardvo", bbsVo);
		return "board/modify";
	}
	
	@RequestMapping(value = "download", method = RequestMethod.GET)
	public void downloadFile(Long fno, HttpServletResponse res) throws Exception {
		AttachFileVo attachFileVo = bbsService.selectAttachFileByFNO(fno);
		String saveName = attachFileVo.getSaveName();
		String orgName = attachFileVo.getOrgName();
		    
		res.setContentType("application/download");
		res.setHeader("Content-disposition", "attachment; filename=\"" + URLEncoder.encode(orgName,"UTF-8") +"\"");
		OutputStream resOut = res.getOutputStream();
		
		FileInputStream fin = new FileInputStream("C:\\upload\\"+saveName);
		FileCopyUtils.copy(fin, resOut);
			
		fin.close();
		    
	}
	
	@RequestMapping(value = "view2", method = RequestMethod.GET)
	public String view2() {
		return "board/view2";
	}

	@ResponseBody	//jsp파일 안찾고 보내줌
	@RequestMapping(value = "readAjax", method = RequestMethod.POST)
	public BBSVo readBoardAjax(@RequestBody BBSVo bbsVo) {	//Request 객체받음, script or DB 객체 분별
//		BBSVo bbsVo = bbsService.readBoard(no);
		System.out.println(bbsVo.toString());
		return bbsVo;
	}
	
}
