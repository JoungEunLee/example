package com.amy.dao;
 
import java.util.List;
 
import javax.inject.Inject;
 
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
 
import com.amy.dto.BoardVO;
 
@Repository
public class BoardDAOImpl implements BoardDAO {
 
    @Inject
    private SqlSession sqlSession;
    
    private static final String Namespace = "com.amy.mapper.boardMapper";

    @Override
    public void create(BoardVO boardVO){
        
        sqlSession.insert(Namespace+".insert", boardVO);
 
    }

    @Override
    public List<BoardVO> selectBoard() throws Exception {
 
        return sqlSession.selectList(Namespace+".selectBoard");
    }
    
    public BoardVO read(int bno) throws Exception{
    	return sqlSession.selectOne(Namespace + ".view", bno);
    }
    
    public void increaseViewcnt(int bno) throws Exception{
    	sqlSession.update(Namespace + ".increaseViewcnt", bno);
    }
    
    public void update(BoardVO vo) throws Exception{
    	sqlSession.update(Namespace + ".updateArticle", vo);
    }
    
    public void delete(int bno) throws Exception{
    	sqlSession.delete(Namespace + ".deleteArticle", bno);
    }
 
}