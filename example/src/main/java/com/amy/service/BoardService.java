package com.amy.service;
 
import java.util.List;

import javax.servlet.http.HttpSession;

import com.amy.dto.BoardVO;
 
public interface BoardService {
	//�Խñ� ��ȸ
    public List<BoardVO> selectBoard() throws Exception;
    
    //�Խñ� �ۼ�
    public void create(BoardVO boardVO) throws Exception;
    
    //�Խñ� ��ȸ
    public void increaseViewcnt(int bno, HttpSession session) throws Exception;

    //�Խñ� �󼼺���
    public BoardVO read(int bno) throws Exception;

    //�Խñ� ����
    public void update(BoardVO boardVO) throws Exception;

    //�Խñ� ����
    public void delete(int bno) throws Exception;


}