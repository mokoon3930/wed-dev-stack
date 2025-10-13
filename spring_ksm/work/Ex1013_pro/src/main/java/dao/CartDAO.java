package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.CartVO;

public class CartDAO {
	
	SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	//ȸ�� �� ��ٱ��� ��� ��ȸ mapper
	public List<CartVO> select( int m_idx ) {
		
		List<CartVO> list = sqlSession.selectList("c.cart_list", m_idx);
		
		return list;
		
	}
	
	// ��ٱ��Ͽ� ��� ��ǰ���� �� ��
	public int selectTotalAmount(int m_idx) {
		
		int total = sqlSession.selectOne("c.cart_total_amount", m_idx);
		
		return total;
	}
	
	//�̹� ��ٱ��Ͽ� ��ϵ� ��ǰ���� ��ȸ
	public CartVO selectOne(CartVO vo) {
		
		CartVO resVo = sqlSession.selectOne("c.cart_one", vo);

		
		return resVo;
	}
	
	//��ٱ��Ͽ� �Ը� �߰�
	public int insert(CartVO vo) {
		
		int res = sqlSession.insert("c.cart_insert", vo);

		return res;
	}
	
	//��ٱ��� ���� ������Ʈ
	public int update_cnt(CartVO vo) {
		
		int res = sqlSession.update("c.cart_cnt", vo);

		return res;
	}
	
	//��ٱ��� ��� ����
	public int delete(int c_idx) {
		
		int res = sqlSession.delete("c.cart_del", c_idx);

		return res;
	}
}
















