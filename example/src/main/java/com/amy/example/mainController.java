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
public class mainController {
	
	private static final Logger logger = LoggerFactory.getLogger(mainController.class);
	
	@Inject
    private MemberService service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/main", method = RequestMethod.POST)
	public String main(Locale locale, Model model) throws Exception{
		logger.info("main");
		
		List<MemberVO> memberList = service.selectMember();
        
        model.addAttribute("memberList", memberList);
		
		return "main";
	}
	
}
