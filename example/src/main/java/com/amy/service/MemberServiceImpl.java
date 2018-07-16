package com.amy.service;
 
import java.util.List;
 
import javax.inject.Inject;
 
import org.springframework.stereotype.Service;
 
import com.amy.dao.MemberDAO;
import com.amy.dto.MemberVO;
 
@Service
public class MemberServiceImpl implements MemberService {
 
    @Inject
    private MemberDAO dao;
    
    @Override
    public List<MemberVO> selectMember() throws Exception {
 
        return dao.selectMember();
    }
 
}