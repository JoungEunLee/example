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
    
    //게시글 상세보기
    @Override
    public BoardVO read(int bno) throws Exception {
        return dao.read(bno);
    }
    
    //게시글 조회수 증가
    @Override
    public void increaseViewcnt(int bno, HttpSession session)throws Exception{
    	long update_time = 0;
    	//세션에 저장된 조회시간 검색
    	//최초로 조회할 경우 세션에 저장된 값이 없기 때문에 if문은 실행x
    	if(session.getAttribute("update_time_" + bno)!=null) {
    		//세션에서 읽어오기
    		update_time = (long)session.getAttribute("update_time_"+bno);
    	}
    	//시스템의 현재시간을 current_time에 저장
    	long current_time = System.currentTimeMillis();
    	//일정시간 경과 후 조회수 처리 24*60*60*1000(24시간)
    	//시스템 현재시간 - 열람시간 > 일정시간(조히ㅗ수 증가가 가능하도록 지정한 시간)
    	if(current_time - update_time > 5 * 1000) {
    		dao.increaseViewcnt(bno);
    		//세션에 시간 저장 : "updatate_time_"+bno는 다른 변수와 중복되지 않게 명명
    		session.setAttribute("update_time_"+bno, current_time);
    	}
    	
    }
    
  //게시글 수정
    @Override
    public void update(BoardVO vo) throws Exception {
        dao.update(vo);
    }
    
  //게시글 삭제
    @Override
    public void delete(int bno) throws Exception {
        dao.delete(bno);
    }
    
 
}