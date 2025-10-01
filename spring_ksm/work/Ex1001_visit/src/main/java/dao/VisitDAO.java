package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.VisitVO;

public class VisitDAO {
	
	SqlSession sqlSession;
	
	public VisitDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		System.out.println("dao»ý¼ºÀÚ");
	}
	
	public List<VisitVO> selectList(){
		List<VisitVO> list = sqlSession.selectList("v.visit_list");
		return list;
	}
	
	public int insertVisit(VisitVO vo) {
		int res = sqlSession.insert("v.insert_visit", vo);
		return res;
	}
	
	public String checkPwd(int idx) {
	    return sqlSession.selectOne("v.checkPwd", idx);
	}
	
	public int delVisit(int idx) {
		int res = sqlSession.delete("v.del_visit", idx);
		return res;
	}
	
	public VisitVO selectOne(int idx) {
		VisitVO vo = sqlSession.selectOne("v.visit_one", idx);
		return vo;
	}
	
	public int updateVisit(VisitVO vo) {
		
	    int res = sqlSession.update("v.update_visit", vo);
	    return res;
	}
}
