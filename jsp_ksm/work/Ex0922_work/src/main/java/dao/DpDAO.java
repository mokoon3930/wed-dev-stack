package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.DpVO;

public class DpDAO {
	
	// _sing - 이렇게만 침면 템플릿이 있어 자동 생성 가능

	
	
	static DpDAO single = null;

	public static DpDAO getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new DpDAO();
		//생성된 객체정보를 반환
		return single;
	}
	
	SqlSessionFactory factory;  // sql 솃션 접그 팩토리
	
	public DpDAO() {
		factory = MyBatisConnector.getInstance().getFactory();
	}
	
	// 목록 가져오기
	public List<DpVO> select(){
		SqlSession sqlSession = factory.openSession();
		List<DpVO> list = sqlSession.selectList("d.dept_list");
		sqlSession.close();
		return list;
	}
	
	// 등록
		public int register(DpVO vo) {
			SqlSession sqlSession = factory.openSession(true);
			int res = sqlSession.insert("d.dept_insert", vo);  // "호출mapper" , vo 정보 보네기 (따로 보네는 X)
			sqlSession.close();
			return res;
		}
		
	// 삭제
		public int delDept( int deptno ) {
			SqlSession sqlSession = factory.openSession(true);
			
			//삭제를 위한 mapper
			int res = sqlSession.delete("d.dept_del", deptno);
			
			sqlSession.close();
			return res;
			
		}
		
	// 수정 목로 1개 조회
	public DpVO modifyDept (int deptno) {
		SqlSession sqlSession = factory.openSession();
		
		DpVO vo = sqlSession.selectOne("d.modify_one", deptno);
		
		sqlSession.close();
		
		return vo;
	}
	
	public int updateFin (Map<String, Object> map) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.update("d.upd_fin" , map);
		sqlSession.close();
		return res;
		
	}
}































