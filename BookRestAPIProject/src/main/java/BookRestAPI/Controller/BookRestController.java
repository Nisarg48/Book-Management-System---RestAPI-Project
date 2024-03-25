package BookRestAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import BookRestAPI.Entities.Books;
import BookRestAPI.Service.BookService;

@RestController
public class BookRestController {

	private BookService bookService;

	@Autowired
	public BookRestController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/books")
	public List<Books> getAllBooks(){
		return bookService.findAll();
	}
	
	@GetMapping("/books/isbn/{isbn}")
	public Books findBookById(@PathVariable int isbn) {
		
		Books book = bookService.findById(isbn);
		
		if(book == null)
		{
			System.out.print("Book is not found");
		}
		return book;
	}
	
//	@GetMapping("/books/{title}")
//	public List<Books> getBookByTitle(@PathVariable String title){
//		System.out.print("Controller Start");
//		List<Books> book = bookService.findByTitle(title);
//		
//		if(book == null)
//		{
//			System.out.print("Book is not found");
//		}
//		System.out.print("Controller End");
//		return book;
//	}
//	
//	@GetMapping("/books/{author}")
//	public List<Books> getBookByAuthor(@PathVariable String author){
//		
//		List<Books> book = bookService.findByAuthor(author);
//		
//		if(book == null)
//		{
//			System.out.print("Book is not found");
//		}
//		return book;
//	}
//	
//	@GetMapping("/books/{yop}")
//	public List<Books> getBookByYOP(@PathVariable String yop){
//		List<Books> book = bookService.findByYearofpublished(yop);
//		if(book == null)
//		{
//			System.out.print("Book is not found");
//		}
//		return book;
//	}
	
	@PostMapping("/books")
	public void addBook(@RequestBody Books book) {
		bookService.addBook(book);
	}
	
	@DeleteMapping("/books/{id}")
	public void deleteBookById(@PathVariable int id) {
		bookService.deleteById(id);
	}
}