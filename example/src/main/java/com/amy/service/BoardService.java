package com.amy.service;
 
import java.util.List;

import javax.servlet.http.HttpSession;

import com.amy.dto.BoardVO;
 
public interface BoardService {
    public List<BoardVO> selectBoard() throws Exception;
    
    public void create(BoardVO boardVO) throws Exception;
    
    public void increaseViewcnt(int bno, HttpSession session) throws Exception;

    public BoardVO read(int bno) throws Exception;

    public void update(BoardVO boardVO) throws Exception;

    public void delete(int bno) throws Exception;


}