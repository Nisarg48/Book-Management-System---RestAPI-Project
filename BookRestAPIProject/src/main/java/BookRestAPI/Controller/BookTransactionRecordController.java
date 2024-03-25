package BookRestAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import BookRestAPI.Service.BookTransactionRecordService;

@RestController
public class BookTransactionRecordController 
{
	private BookTransactionRecordService bookTransactionRecordService;
	
	@Autowired
	public BookTransactionRecordController(@Qualifier("bookTransactionRecordServiceImpl") BookTransactionRecordService bookTransactionRecordService) {
		this.bookTransactionRecordService = bookTransactionRecordService;
	}
	
	@PostMapping("/borrowBook/{isbn}/{uid}")
	public void BorrowBook(@PathVariable("isbn") int isbn, @PathVariable("uid") int id)
	{
		bookTransactionRecordService.BorrowBook(isbn, id);
	}
	
	@PutMapping("/returnBook/{isbn}/{uid}")
	public void ReturnBook(@PathVariable("isbn") int isbn, @PathVariable("uid") int id)
	{
		bookTransactionRecordService.ReturnBook(isbn, id);
	}
}