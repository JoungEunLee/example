package com.amy.dao;
 
import java.util.List;
 
import com.amy.dto.BoardVO;


public interface BoardDAO {
    
	//�Խñ� �ۼ�
    public void create(BoardVO boardVO) throws Exception;
	
    public List<BoardVO> selectBoard() throws Exception;
    
}