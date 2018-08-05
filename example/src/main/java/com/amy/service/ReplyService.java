package com.amy.service;
 
import java.util.List;

import javax.servlet.http.HttpSession;

import com.amy.dto.ReplyVO;
 
public interface ReplyService {
    public List<ReplyVO> listReply(int bno) throws Exception;
    
    public void addReply(ReplyVO vo) throws Exception;
    
    public void modifyReply(ReplyVO vo) throws Exception;

    public void removeReply(int rno) throws Exception;

}