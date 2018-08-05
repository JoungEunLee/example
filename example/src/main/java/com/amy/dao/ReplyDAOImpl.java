package com.amy.dao;
 
import java.util.List;
 
import javax.inject.Inject;
 
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
 
import com.amy.dto.ReplyVO;
 
@Repository
public class ReplyDAOImpl implements ReplyDAO {
 
    @Inject
    private SqlSession sqlSession;
    
    private static final String Namespace = "com.amy.mapper.ReplyMapper";

    
    @Override
    public List<ReplyVO> list(int bno) throws Exception {
 
        return sqlSession.selectList(Namespace+".list", bno);
    }
    
    @Override
    public void create(ReplyVO vo) throws Exception {
        
        sqlSession.insert(Namespace+".create", vo);
 
    }
    
    public void update(ReplyVO vo) throws Exception{
    	sqlSession.update(Namespace + ".update", vo);
    }
    
    public void delete(int rno) throws Exception{
    	sqlSession.delete(Namespace + ".delete", rno);
    }
 
}