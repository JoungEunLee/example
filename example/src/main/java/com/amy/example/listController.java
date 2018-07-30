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
	        // ModelAndView - 乞季引 坂
	        ModelAndView mav = new ModelAndView();
	        mav.setViewName("list"); // 坂研 list.jsp稽 竺舛
	        mav.addObject("list", list); // 汽戚斗研 煽舌
	        return mav; // list.jsp稽 List亜 穿含吉陥.
	    }
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
    public String write(){
		System.out.println("write 級嬢尽陥たたたたたたたたた");
        return "/write"; // write.jsp稽 戚疑
    }
	
	//惟獣越 拙失坦軒
    @RequestMapping(value="/insert", method=RequestMethod.POST)
    public String insert(@ModelAttribute BoardVO boardVO) throws Exception{
        //service.selectBoard();
    	System.out.println("insert 梅陥たたたたたたたたた");
        service.create(boardVO);
        return "redirect:/list";
    }
    
  //惟獣越 雌室 繕噺
    @RequestMapping(value="/view", method=RequestMethod.GET)
    public ModelAndView view(@RequestParam int bno, HttpSession session) throws Exception{
    	System.out.println("view 梅陥たたたたたたたたた");
    	//繕噺呪 装亜 坦軒
    	service.increaseViewcnt(bno,session);
    	//乞季(汽戚斗) + 坂(鉢檎) 敗惟 穿含馬澗 梓端
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("view");
    	mav.addObject("dto",service.read(bno));
    	return mav;
    }
    
    //惟獣越 呪舛
    //廿拭辞 脊径廃 鎧遂級精 @ModelAttribute BoardVo vo稽 穿含喫
    @RequestMapping(value="/update", method=RequestMethod.POST)
    public String update(@ModelAttribute BoardVO boardVO) throws Exception{
    	System.out.println("update 梅陥たたたたたたたたた");
        service.update(boardVO);
        return "redirect:/list";
    }
    
  //惟獣越 肢薦
    @RequestMapping(value="/delete")
    public String delete(@RequestParam int bno) throws Exception{
    	System.out.println("delete 梅陥たたたたたたたたた");
        service.delete(bno);
        return "redirect:/list";
    }


}
