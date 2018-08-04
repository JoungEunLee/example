package com.amy.example;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.amy.dto.MemberVO;
import com.amy.service.MemberService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
    private MemberService service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public void homeGET(MemberVO memberVO, Model model) throws Exception{
		
		System.out.println("/home GET 방식입니다");
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String homePOST(MemberVO memberVO, Model model) throws Exception{
		
		System.out.println("/home POST 방식입니다");
		
		service.insertMember(memberVO);
		model.addAttribute("result", "성공");
		
		return "forward:/main";
	}
}
