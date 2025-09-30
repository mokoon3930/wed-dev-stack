package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.MemberVO;


public class MemberDAO {
	
	SqlSession sqlSession;
	
//	public void setSqlSession(SqlSession sqlSession) {
//		this.sqlSession = sqlSession;
//	}
	
	public MemberDAO (SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//회원 조회 - DB접근
	public List<MemberVO> selectList(){
		List<MemberVO> list = sqlSession.selectList("m.member_list");
		return list;
	}
	
	
	// 맴버 추가
	public int memberInsert(MemberVO vo) {
		int res = sqlSession.insert("m.member_regi", vo);
		return res;
	}
	
	//아이디 체크
	public MemberVO selectIdCheck(String id) {
		
		MemberVO vo = sqlSession.selectOne("m.id_check",id);
		return vo;
		
	}
	
	//유저삭제
	public int delMember(int idx) {
		int res = sqlSession.delete("m.del_member", idx);
		return res;
	}
	
	//유저 1명 검색
	public MemberVO selectOne(int idx) {
		MemberVO vo = sqlSession.selectOne("m.sel_member", idx);
		return vo;
	}
	
	//유저 수정
	public int memberUpdate(MemberVO vo) {
		int res = sqlSession.update("m.member_update", vo);
		return res;
	}
}



















