package com.amy.dao;
 
import java.util.List;
 
import com.amy.dto.BoardVO;


public interface BoardDAO {
    
    public void create(BoardVO boardVO) throws Exception;
	
    public List<BoardVO> selectBoard() throws Exception;
    
    public BoardVO read(int bno) throws Exception;
    
    public void increaseViewcnt(int bno) throws Exception;

    public void update(BoardVO vo) throws Exception;

    public void delete(int bno) throws Exception;

}