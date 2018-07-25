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

  //������ �߰�
    @Override
    public void create(BoardVO boardVO){
        
        sqlSession.insert(Namespace+".insert", boardVO);
 
    }

    //������ ����
    @Override
    public List<BoardVO> selectBoard() throws Exception {
 
        return sqlSession.selectList(Namespace+".selectBoard");
    }
 
}