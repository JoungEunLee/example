package com.amy.service;
 
import java.util.List;
 
import com.amy.dto.BoardVO;
 
public interface BoardService {
	//�Խñ� ��ȸ
    public List<BoardVO> selectBoard() throws Exception;
    
    //�Խñ� �ۼ�
    public void create(BoardVO boardVO) throws Exception;
}