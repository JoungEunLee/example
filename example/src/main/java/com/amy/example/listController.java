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
    
  //게시글 상세 조회
    @RequestMapping(value="/view", method=RequestMethod.GET)
    public ModelAndView view(@RequestParam int bno, HttpSession session) throws Exception{
    	System.out.println("view 했다ㅏㅏㅏㅏㅏㅏㅏㅏㅏ");
    	//조회수 증가 처리
    	service.increaseViewcnt(bno,session);
    	//모델(데이터) + 뷰(화면) 함게 전달하는 객체
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("view");
    	mav.addObject("dto",service.read(bno));
    	return mav;
    }
    
    //게시글 수정
    //폼에서 입력한 내용들은 @ModelAttribute BoardVo vo로 전달됨
    @RequestMapping(value="/update", method=RequestMethod.POST)
    public String update(@ModelAttribute BoardVO boardVO) throws Exception{
    	System.out.println("update 했다ㅏㅏㅏㅏㅏㅏㅏㅏㅏ");
        service.update(boardVO);
        return "redirect:/list";
    }
    
  //게시글 삭제
    @RequestMapping(value="/delete")
    public String delete(@RequestParam int bno) throws Exception{
    	System.out.println("delete 했다ㅏㅏㅏㅏㅏㅏㅏㅏㅏ");
        service.delete(bno);
        return "redirect:/list";
    }


}
