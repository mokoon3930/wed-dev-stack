package dao;

import java.awt.SplashScreen;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.ProductVO;

public class ProductDAO {
	
	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static ProductDAO single = null;

	public static ProductDAO getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new ProductDAO();
		//생성된 객체정보를 반환
		return single;
	}
	
	SqlSessionFactory factory;
	
	public ProductDAO() {
		factory = MyBatisConnector.getInstance().getFactory();
	}
	
	//카테고리별 상품 자져오기
	public List<ProductVO> select( String category ) {
		SqlSession sqlSession = factory.openSession();
		List<ProductVO> list = sqlSession.selectList("p.pro_list", category);
		sqlSession.close();
		
		return list;
	}

	public int insert(ProductVO vo) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.insert("p.pro_insert", vo);
		sqlSession.close();
		return res;
					
	}
	
	public ProductVO modfiy(int idx) {
		SqlSession sqlSession = factory.openSession();
		ProductVO vo = sqlSession.selectOne("p.pro_modify", idx);
		sqlSession.close();
		
		return vo;
	}
	
	public int update(ProductVO vo) {
		SqlSession sqlSession = factory.openSession();
		int res = sqlSession.update("p.update", vo);
		sqlSession.close();
		return res;
	}
	
}

























