package com.amy.dao;
 
import java.util.List;
 
import javax.inject.Inject;
 
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
 
import com.amy.dto.MemberVO;
 
@Repository
public class MemberDAOImpl implements MemberDAO {
 
    @Inject
    private SqlSession sqlSession;
    
    private static final String Namespace = "com.amy.mapper.memberMapper";
    
    //데이터 추가
    @Override
    public void insertMember(MemberVO memberVO){
        
        sqlSession.insert(Namespace+".insertMember", memberVO);
 
    }

    //데이터 보기
    @Override
    public List<MemberVO> selectMember() throws Exception {
 
        return sqlSession.selectList(Namespace+".selectMember");
    }
 
}