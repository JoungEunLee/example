package com.amy.dao;
 
import java.util.List;
 
import com.amy.dto.BoardVO;


public interface BoardDAO {
    
	//게시글 작성
    public void create(BoardVO boardVO) throws Exception;
	
    public List<BoardVO> selectBoard() throws Exception;
    
}