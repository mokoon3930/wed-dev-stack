package service;

import java.util.List;

import dao.BoardDAO;

public class BoardServiceImpl implements BoardService{

	BoardDAO dao;
	
	public BoardServiceImpl( BoardDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List selectList() {
		
		return dao.selectList();
	}

}
