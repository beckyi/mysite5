package kr.ac.sungkyul.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.sungkyul.mysite.service.GuestbookService;
import kr.ac.sungkyul.mysite.vo.GuestbookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {

	@Autowired // 객체 데이터 타입 자동화 변경 및 연결
	GuestbookService guestbookService;

	@RequestMapping("/list")
	public String list(Model model) {

		List<GuestbookVo> gvo = guestbookService.list();
		model.addAttribute("vo", gvo);

		return "guestbook/list";
	}
}
