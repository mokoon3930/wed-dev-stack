package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor@AllArgsConstructor@Data
public class Book {
	
	private int bookNo; // primary key -----> book_no
	private String title;
	private String author;
	private int accessAge;
}
