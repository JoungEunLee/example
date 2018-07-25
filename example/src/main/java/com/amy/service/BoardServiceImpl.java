package com.amy.service;
 
import java.util.List;
 
import javax.inject.Inject;
 
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
 
}