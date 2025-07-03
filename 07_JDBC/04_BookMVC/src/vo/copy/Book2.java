package vo.copy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor@AllArgsConstructor@Data
public class Book2 {
	
	private int bookNO; // primary key -----> book_no
	private String title;
	private String author;
	private String accessAge;
}
