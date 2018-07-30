package com.amy.service;
 
import java.util.List;

import javax.servlet.http.HttpSession;

import com.amy.dto.BoardVO;
 
public interface BoardService {
	//게시글 조회
    public List<BoardVO> selectBoard() throws Exception;
    
    //게시글 작성
    public void create(BoardVO boardVO) throws Exception;
    
    //게시글 조회
    public void increaseViewcnt(int bno, HttpSession session) throws Exception;

    //게시글 상세보기
    public BoardVO read(int bno) throws Exception;

    //게시글 수정
    public void update(BoardVO boardVO) throws Exception;

    //게시글 삭제
    public void delete(int bno) throws Exception;


}