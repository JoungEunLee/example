package com.amy.service;
 
import java.util.List;
 
import com.amy.dto.BoardVO;
 
public interface BoardService {
	//게시글 조회
    public List<BoardVO> selectBoard() throws Exception;
    
    //게시글 작성
    public void create(BoardVO boardVO) throws Exception;
}