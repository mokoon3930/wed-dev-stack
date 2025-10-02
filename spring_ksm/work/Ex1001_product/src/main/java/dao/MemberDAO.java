package dao;

import org.apache.ibatis.session.SqlSession;

import vo.MemberVO;

public class MemberDAO {

	SqlSession sqlSession;
	
	public MemberDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// 로그인 확인
	public MemberVO select(String id) {
		MemberVO vo = sqlSession.selectOne("m.select_id", id);
		return vo;
		
	}
}
