package BookRestAPI.Dao;

import BookRestAPI.Entities.Books;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    private EntityManager entityManager;

    @Autowired
    public BookDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Books> findAll() {
        String s = "SELECT b From Books b";
        TypedQuery<Books> sql = entityManager.createQuery(s, Books.class);
        List<Books> book = sql.getResultList();
        return book;
    }

    @Override
    public Books findById(int isbn) {
        Books book = entityManager.find(Books.class, isbn);
        try {
            return book;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void addBook(Books book) {
        book.setIsAvailable(1);
        Books mergedBook = entityManager.merge(book); // Merge the entity and get the managed instance
        entityManager.persist(mergedBook); // Persist the managed instance
    }

    @Override
    public void deleteById(int id) {
        Books book = entityManager.find(Books.class, id);
        entityManager.remove(book);
    }

//	@Override
//	public List<Books> findByTitle(String title) {
//	    TypedQuery<Books> sql = entityManager.createQuery("SELECT b FROM books b WHERE b.title like :title", Books.class);
//	    s
//	    ql.setParameter("title", title);
//	    System.out.print("This is DaoImpl");
//	    return sql.getResultList();
//	}
//	@Override
//	public List<Books> findByTitle(String title) {
//	    TypedQuery<Books> sql = entityManager.createQuery("SELECT b FROM Books b WHERE b.title = :title", Books.class);
//	    sql.setParameter("title", title);
//	    System.out.print("This is DaoImpl");
//	    return sql.getResultList();
//	}
//
//	
//	@Override
//	public List<Books> findByAuthor(String author) {
//		TypedQuery<Books> sql = entityManager.createQuery("SELECT b FROM Books b WHERE b.author = :author", Books.class);
//		sql.setParameter("author", author);
//		
//		List<Books> book = sql.getResultList();
//		return book;
//	}
//
//	@Override
//	public List<Books> findByGenre(String genre) {
//		
//		return null;
//	}
//
//	@Override
//	public List<Books> findByYearofpublished(String yop){
//		TypedQuery<Books> sql = entityManager.createQuery("SELECT b FROM Books b WHERE b.yearOfPublished = :yearOfPublished", BookRestAPI.Entities.Books.class);
//	    sql.setParameter("yearOfPublished", yop);
//	    System.out.print("This is DaoImpl");
//	    return sql.getResultList();
//	}
}
