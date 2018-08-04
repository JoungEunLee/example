package com.amy.example;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amy.dto.BoardVO;
import com.amy.dto.MemberVO;
import com.amy.service.BoardService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class listController {
	
	
	@Inject
    private BoardService service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/list")
	    public ModelAndView list() throws Exception{
	        List<BoardVO> list = service.selectBoard();
	        ModelAndView mav = new ModelAndView();
	        mav.setViewName("list");
	        mav.addObject("list", list);
	        return mav; 
	    }
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
    public String write(){
		System.out.println("write 들어왔다");
        return "/write"; 
    }
	
    @RequestMapping(value="/insert", method=RequestMethod.POST)
    public String insert(@ModelAttribute BoardVO boardVO) throws Exception{
    	System.out.println("insert 들어왔다");
        service.create(boardVO);
        return "redirect:/list";
    }
    
    @RequestMapping(value="/view", method=RequestMethod.GET)
    public ModelAndView view(@RequestParam int bno, HttpSession session) throws Exception{
    	System.out.println("view 들어왔다");
    	service.increaseViewcnt(bno,session);
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("view");
    	mav.addObject("dto",service.read(bno));
    	return mav;
    }
    
    @RequestMapping(value="/update", method=RequestMethod.POST)
    public String update(@ModelAttribute BoardVO boardVO) throws Exception{
    	System.out.println("update 들어왔다");
        service.update(boardVO);
        return "redirect:/list";
    }
    
    @RequestMapping(value="/delete")
    public String delete(@RequestParam int bno) throws Exception{
    	System.out.println("delete 들어왔다");
        service.delete(bno);
        return "redirect:/list";
    }


}
