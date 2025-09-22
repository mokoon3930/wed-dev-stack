package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.DpVO;

public class DpDAO {

	SqlSessionFactory factory;
	
	static DpDAO single = null;

	public static DpDAO getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new DpDAO();
		//생성된 객체정보를 반환
		return single;
	}
	 
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
	
	
		public int register(DpVO vo) {
			SqlSession sqlSession = factory.openSession(true);
			int res = sqlSession.insert("d.dept_insert", vo);  // "호출mapper" , vo 정보 보네기 (따로 보네는 X)
			sqlSession.close();
			return res;
			
		}
		
		
		public int del( int no ) {
			SqlSession sqlSession = factory.openSession(true);
			
			//삭제를 위한 mapper
			int res = sqlSession.delete("d.dept_del", no);
			
			sqlSession.close();
			return res;
			
		}
}
