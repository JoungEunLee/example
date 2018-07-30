package com.amy.dao;
 
import java.util.List;
 
import com.amy.dto.BoardVO;


public interface BoardDAO {
    
	//게시글 작성
    public void create(BoardVO boardVO) throws Exception;
	
    public List<BoardVO> selectBoard() throws Exception;
    
    //게시글 상세보기
    public BoardVO read(int bno) throws Exception;
    
    //게시글 조회 증가
    public void increaseViewcnt(int bno) throws Exception;

  //게시글 수정
    public void update(BoardVO vo) throws Exception;

  //게시글 삭제
    public void delete(int bno) throws Exception;

}