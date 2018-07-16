package com.amy.dao;
 
import java.util.List;
 
import com.amy.dto.MemberVO;


public interface MemberDAO {
    
    public List<MemberVO> selectMember() throws Exception;
    
    public void insertMember(MemberVO memberVO);
}