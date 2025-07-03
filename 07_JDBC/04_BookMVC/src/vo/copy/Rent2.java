package vo.copy;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor@AllArgsConstructor@Data
public class Rent2 {
	
	private int rentNo;
	private String id; // foreign key (Client)
	private int bookNo; // foreign key (Book) ---> book_no
	private LocalDate rentDate; // -----> rent_date
	
	private Member2 client;
	private Book2 book;
}
