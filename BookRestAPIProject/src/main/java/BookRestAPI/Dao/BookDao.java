package BookRestAPI.Dao;

import java.util.List;

import BookRestAPI.Entities.Books;

public interface BookDao
{	
	public List<Books> findAll();
	
	public Books findById(int isbn);
	
//	public List<Books> findByTitle(String title);
//	
//	public List<Books> findByAuthor(String author);
//	
//	public List<Books> findByGenre(String genre);
//	
//	public List<Books> findByYearofpublished(String yop);
	
	public void addBook(Books book);
	
	public void deleteById(int id);
	
}
