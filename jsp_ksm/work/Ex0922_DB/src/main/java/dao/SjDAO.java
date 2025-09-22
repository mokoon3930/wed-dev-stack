package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.SjVO;

public class SjDAO {
	
	SqlSessionFactory factory;
	
	static SjDAO single = null;

	public static SjDAO getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new SjDAO();
		//생성된 객체정보를 반환
		return single;
	}
	
	public SjDAO() {
		factory = MyBatisConnector.getInstance().getFactory();
	}
	
	// 학생 목록을 가져오기
	public List<SjVO> select(){
		//mapper로 접근 하기 위한 Sqlsession객체 준비
		SqlSession sqlSession = factory.openSession();
		List<SjVO> list = sqlSession.selectList("s.sj_list");
		sqlSession.close();
		
		return list;
	}
}
