package kr.ac.sungkyul.mysite.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.sungkyul.mysite.service.UserService;
import kr.ac.sungkyul.mysite.vo.UsersVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired	//객체 데이터 타입 자동화 변경 및 연결
	UserService userService;
	
	@RequestMapping("/joinform")
	public String joinform(){
		return "user/joinform";
	}
	
	@RequestMapping("/modifyform")
	public String modifyform(HttpSession session, Model model){
		UsersVo temp = (UsersVo)session.getAttribute("authUser");
		
		Long no = temp.getNo();
		
		UsersVo nvo = userService.get(no);
		model.addAttribute("userVo", nvo);
		
		return "user/modifyform";
	}
	
	@RequestMapping("/modify")
	public String modify(HttpSession session, @ModelAttribute UsersVo vo){
		
		UsersVo temp = (UsersVo)session.getAttribute("authUser");
		Long no = temp.getNo();
		
		vo.setNo(no);
		
		userService.update(vo);
		return "redirect:/user/modifyform";
	}
	
	@RequestMapping("/join")
	public String join(@ModelAttribute UsersVo vo){
		userService.join(vo);
		return "redirect:/user/joinsuccess";
	}
	
	@RequestMapping("/joinsuccess")
	public String joinSuccess(){
		return "user/joinsuccess";
	}
	
	@RequestMapping("/loginform")
	public String loginform(){
		return "user/loginform";
	}
	
	@RequestMapping(value= "/login", method= RequestMethod.POST)
	public String login(
			HttpSession session,
			@RequestParam(value= "email", required=false, defaultValue="") String email,
			@RequestParam(value="password", required=false, defaultValue="") String password){
		
		UsersVo authUser =  userService.login(email,  password);
		
		if(authUser == null){
			return "redirect:/user/loginform";
		}
		
		//인증성공
		session.setAttribute("authUser",authUser);
		return "redirect:/main";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("authUser");
		session.invalidate();	//로그아웃 처리 시 세션을 지워줌
		
		return "redirect:/main";
	}
}
