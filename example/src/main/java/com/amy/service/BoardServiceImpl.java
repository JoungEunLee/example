package com.amy.service;
 
import java.util.List;
 
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
 
import com.amy.dao.BoardDAO;
import com.amy.dto.BoardVO;
 
@Service
public class BoardServiceImpl implements BoardService {
 
    @Inject
    private BoardDAO dao;
 
    @Override
    public void create(BoardVO boardVO) throws Exception {
        dao.create(boardVO);
 
    }
	
    @Override
    public List<BoardVO> selectBoard() throws Exception {
 
        return dao.selectBoard();
    }
    
    @Override
    public BoardVO read(int bno) throws Exception {
        return dao.read(bno);
    }
    
    @Override
    public void increaseViewcnt(int bno, HttpSession session)throws Exception{
    	long update_time = 0;
    	if(session.getAttribute("update_time_" + bno)!=null) {
    		update_time = (long)session.getAttribute("update_time_"+bno);
    	}
    	long current_time = System.currentTimeMillis();
    	if(current_time - update_time > 5 * 1000) {
    		dao.increaseViewcnt(bno);
    		session.setAttribute("update_time_"+bno, current_time);
    	}
    	
    }
    
    @Override
    public void update(BoardVO vo) throws Exception {
        dao.update(vo);
    }
    
    @Override
    public void delete(int bno) throws Exception {
        dao.delete(bno);
    }
    
 
}