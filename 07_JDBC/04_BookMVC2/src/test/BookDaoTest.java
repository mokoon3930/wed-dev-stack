package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.BookDAO;
import vo.Book;

class BookDaoTest {
	
	private BookDAO dao;


	@BeforeEach
	void setUp() throws Exception {
		dao = BookDAO.getInstance();
	}
	@AfterEach
	void setDown() throws SQLException {
		dao.connect().prepareStatement("DELETE FROM book").executeUpdate();
	}

	@Test
	void testRegisterPrint() throws SQLException {
		dao.registerBook("오늘의 낙원에서 만나자", "하태완", 15);
		ArrayList<Book> list = dao.printBookAll();
		assertEquals(list.get(0).getAuthor(), "하태완");
	}
	
	@Test
	void testsellBook() throws SQLException {
		dao.registerBook("오늘의 낙원에서 만나자", "하태완", 15);
		
		ArrayList<Book> list = dao.printBookAll();
		dao.sellBook(list.get(0).getBookNo());
		
		list = dao.printBookAll();
		assertEquals(list.size(), 0);
		assertTrue(list.isEmpty());
	}

}















