package dao;

import org.apache.ibatis.session.SqlSession;

import vo.MemberVO;

public class MemberDAO {

	SqlSession sqlSession;
	
	public MemberDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// �α��� Ȯ��
	public MemberVO select(String id) {
		MemberVO vo = sqlSession.selectOne("m.select_id", id);
		return vo;
		
	}
}
