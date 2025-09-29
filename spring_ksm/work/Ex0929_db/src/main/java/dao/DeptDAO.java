package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.DeptVO;

public class DeptDAO {
	
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//부서목록
	public List<DeptVO> selectList(){
		List<DeptVO> list = sqlSession.selectList("d.dept_list");
		return list;
	}
	
	// 수정 목로 1개 조회
	public DeptVO modifyDept (int deptno) {
		DeptVO vo = sqlSession.selectOne("d.modify_one", deptno);
		return vo;
	}
}
