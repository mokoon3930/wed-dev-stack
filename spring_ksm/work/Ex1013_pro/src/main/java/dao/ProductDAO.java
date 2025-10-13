package dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.ProductVO;

public class ProductDAO {
	
	SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	//카테고리별 상품 자져오기
	public List<ProductVO> select( String category ) {
		
		List<ProductVO> list = sqlSession.selectList("p.pro_list", category);

		
		return list;
	}

	public int insert(ProductVO vo) {
		
		int res = sqlSession.insert("p.pro_insert", vo);

		return res;
					
	}
	
	public ProductVO modfiy(int idx) {
		
		ProductVO vo = sqlSession.selectOne("p.pro_modify", idx);
		
		return vo;
	}
	
	public int update(ProductVO vo) {
		
		int res = sqlSession.update("p.update", vo);

		return res;
	}
	
	public ProductVO selectOne (int idx) {
		
		ProductVO vo = sqlSession.selectOne("p.pro_one", idx);
		
		return vo;
		
	}
	
}

























