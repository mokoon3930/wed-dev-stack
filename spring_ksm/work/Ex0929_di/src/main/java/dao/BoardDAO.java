package dao;

import java.util.List;

public interface BoardDAO {
	//부모(BoardDAO) 추상 method
	int insert(Object ob);
	List selectList();
}
