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
    
    //�Խñ� �󼼺���
    @Override
    public BoardVO read(int bno) throws Exception {
        return dao.read(bno);
    }
    
    //�Խñ� ��ȸ�� ����
    @Override
    public void increaseViewcnt(int bno, HttpSession session)throws Exception{
    	long update_time = 0;
    	//���ǿ� ����� ��ȸ�ð� �˻�
    	//���ʷ� ��ȸ�� ��� ���ǿ� ����� ���� ���� ������ if���� ����x
    	if(session.getAttribute("update_time_" + bno)!=null) {
    		//���ǿ��� �о����
    		update_time = (long)session.getAttribute("update_time_"+bno);
    	}
    	//�ý����� ����ð��� current_time�� ����
    	long current_time = System.currentTimeMillis();
    	//�����ð� ��� �� ��ȸ�� ó�� 24*60*60*1000(24�ð�)
    	//�ý��� ����ð� - �����ð� > �����ð�(�����Ǽ� ������ �����ϵ��� ������ �ð�)
    	if(current_time - update_time > 5 * 1000) {
    		dao.increaseViewcnt(bno);
    		//���ǿ� �ð� ���� : "updatate_time_"+bno�� �ٸ� ������ �ߺ����� �ʰ� ���
    		session.setAttribute("update_time_"+bno, current_time);
    	}
    	
    }
    
  //�Խñ� ����
    @Override
    public void update(BoardVO vo) throws Exception {
        dao.update(vo);
    }
    
  //�Խñ� ����
    @Override
    public void delete(int bno) throws Exception {
        dao.delete(bno);
    }
    
 
}