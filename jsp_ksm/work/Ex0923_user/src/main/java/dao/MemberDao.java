package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;

import vo.MemberVo;

public class MemberDao {
	
	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static MemberDao single = null;

	public static MemberDao getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new MemberDao();
		//생성된 객체정보를 반환
		return single;
	}
	
	SqlSessionFactory factory;
	
	public MemberDao() {
		factory = MyBatisConnector.getInstance().getFactory();
	}
	
	// 전체 회원 조회
		public List<MemberVo> selectList(){
			SqlSession sqlSession = factory.openSession();
			List<MemberVo> list = sqlSession.selectList("m.selectList");
			sqlSession.close();
			return list;
		}
		
	// 회원 가입
		public int insertMember(MemberVo vo) {
			SqlSession sqlSession = factory.openSession(true); // insert 목적 true (컴잇) 꼭해주기
			int res = sqlSession.insert("m.insert_member", vo);  // "호출mapper" , vo 정보 보네기 (따로 보네는 X)
			sqlSession.close();
			return res;
		}
		
		
	// 회원 삭제	
		public int deleteMember( int idx ) {
			SqlSession sqlSession = factory.openSession(true);
			int res = sqlSession.delete("m.del_member", idx);
			sqlSession.close();
			return res;
			
		}
		
		// 수정 목로 1개 조회
		public MemberVo memberOne (int idx) {
			SqlSession sqlSession = factory.openSession();
			
			MemberVo vo = sqlSession.selectOne("m.select_member", idx);
			
			sqlSession.close();
			
			return vo;
			
		}
		
		public int memberUpdate (Map<String, Object>map) {
			SqlSession sqlSession = factory.openSession(true);
			int res = sqlSession.update("m.update_member" , map);
			sqlSession.close();
			return res;
			
		}
		
}


















