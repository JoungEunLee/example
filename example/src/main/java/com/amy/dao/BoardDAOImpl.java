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

  //데이터 추가
    @Override
    public void create(BoardVO boardVO){
        
        sqlSession.insert(Namespace+".insert", boardVO);
 
    }

    //데이터 보기
    @Override
    public List<BoardVO> selectBoard() throws Exception {
 
        return sqlSession.selectList(Namespace+".selectBoard");
    }
    
    //게시글 상세보기
    public BoardVO read(int bno) throws Exception{
    	return sqlSession.selectOne(Namespace + ".view", bno);
    }
    
  //게시글 조회수 증가
    public void increaseViewcnt(int bno) throws Exception{
    	sqlSession.update(Namespace + ".increaseViewcnt", bno);
    }
    
  //게시글 수정
    public void update(BoardVO vo) throws Exception{
    	sqlSession.update(Namespace + ".updateArticle", vo);
    }
    
  //게시글 삭제
    public void delete(int bno) throws Exception{
    	sqlSession.delete(Namespace + ".deleteArticle", bno);
    }
 
}