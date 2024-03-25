package BookRestAPI.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import BookRestAPI.Dao.BookDao;
import BookRestAPI.Entities.Books;

@Service
public class BookServiceImpl implements BookService {

	private BookDao bookDao;
	
	@Autowired
	public BookServiceImpl(@Qualifier("bookDaoImpl") BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	@Transactional
	public List<Books> findAll() {
		return bookDao.findAll();
	}

	@Override
	@Transactional
	public Books findById(int isbn) {
		return bookDao.findById(isbn);
	}

//	@Override
//	@Transactional
//	public List<Books> findByTitle(String title) {
//		 System.out.print("This is ServiceImpl");
//		return bookDao.findByTitle(title);
//	}
//
//	@Override
//	@Transactional
//	public List<Books> findByAuthor(String author) {
//		return bookDao.findByAuthor(author);
//	}
//
//	@Override
//	@Transactional
//	public List<Books> findByGenre(String genre) {
//		return null;
//	}
//
//	@Override
//	@Transactional
//	public List<Books> findByYearofpublished(String yop) {
//		return bookDao.findByYearofpublished(yop);
//	}
	
	@Override
	@Transactional
	public void addBook(Books book) {
		bookDao.addBook(book);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		bookDao.deleteById(id);
	}
}
