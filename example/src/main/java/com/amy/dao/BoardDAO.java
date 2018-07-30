package com.amy.dao;
 
import java.util.List;
 
import com.amy.dto.BoardVO;


public interface BoardDAO {
    
	//�Խñ� �ۼ�
    public void create(BoardVO boardVO) throws Exception;
	
    public List<BoardVO> selectBoard() throws Exception;
    
    //�Խñ� �󼼺���
    public BoardVO read(int bno) throws Exception;
    
    //�Խñ� ��ȸ ����
    public void increaseViewcnt(int bno) throws Exception;

  //�Խñ� ����
    public void update(BoardVO vo) throws Exception;

  //�Խñ� ����
    public void delete(int bno) throws Exception;

}