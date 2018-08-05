package com.amy.service;
 
import java.util.List;
 
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
 
import com.amy.dao.ReplyDAO;
import com.amy.dto.ReplyVO;
 
@Service
public class ReplyServiceImpl implements ReplyService {
 
    @Inject
    private ReplyDAO dao;
 
    @Override
    public List<ReplyVO> listReply(int bno) throws Exception{
    	return dao.list(bno);
    }
    
    
    @Override
    public void addReply(ReplyVO vo) throws Exception{
    	dao.create(vo);
    }
    
    
    @Override
    public void modifyReply(ReplyVO vo) throws Exception{
    	dao.update(vo);
    }

    
    @Override
    public void removeReply(int rno) throws Exception{
    	dao.delete(rno);
    }
 
}