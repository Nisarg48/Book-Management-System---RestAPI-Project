package BookRestAPI.Dao;

import BookRestAPI.Entities.Books;

import java.util.List;

public interface BookDao {
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
