package com.amy.service;
 
import java.util.List;
 
import com.amy.dto.MemberVO;
 
public interface MemberService {
	
	public void insertMember(MemberVO memberVO)throws Exception;
    
    public List<MemberVO> selectMember() throws Exception;
}