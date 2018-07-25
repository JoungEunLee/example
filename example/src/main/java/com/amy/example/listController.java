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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	        // ModelAndView - 모델과 뷰
	        ModelAndView mav = new ModelAndView();
	        mav.setViewName("list"); // 뷰를 list.jsp로 설정
	        mav.addObject("list", list); // 데이터를 저장
	        return mav; // list.jsp로 List가 전달된다.
	    }
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
    public String write(){
		System.out.println("write 들어왔다ㅏㅏㅏㅏㅏㅏㅏㅏㅏ");
        return "/write"; // write.jsp로 이동
    }
	
	//게시글 작성처리
    @RequestMapping(value="/insert", method=RequestMethod.POST)
    public String insert(@ModelAttribute BoardVO boardVO) throws Exception{
        //service.selectBoard();
    	System.out.println("insert 했다ㅏㅏㅏㅏㅏㅏㅏㅏㅏ");
        service.create(boardVO);
        return "redirect:/list";
    }

}
