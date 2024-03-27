package BookRestAPI.Dao;

import BookRestAPI.Entities.BookTransactionRecord;
import BookRestAPI.Entities.Books;
import BookRestAPI.Entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Calendar;

@Repository
public class BookTransactionRecordDaoImpl implements BookTransactionRecordDao {
    private EntityManager entityManager;

    @Autowired
    public BookTransactionRecordDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void BorrowBook(int isbn, int id) {
        Books book = entityManager.find(Books.class, isbn);
        User user = entityManager.find(User.class, id);

        book.setIsAvailable(0);
        entityManager.merge(book);

        BookTransactionRecord bookTransactionRecord = new BookTransactionRecord();
        bookTransactionRecord.setBook(book);
        bookTransactionRecord.setUser(user);

        java.util.Date currentDate = Calendar.getInstance().getTime();
        java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
        bookTransactionRecord.setBorrowDate(sqlDate);

        entityManager.persist(bookTransactionRecord);
    }

    @Override
    public void ReturnBook(int isbn, int id) {
        Books book = entityManager.find(Books.class, isbn);
        book.setIsAvailable(1);
        entityManager.merge(book);

        String sql = "FROM BookTransactionRecord b WHERE b.book.isbn = :isbn AND b.user.uid = :id";
        TypedQuery<BookTransactionRecord> q = entityManager.createQuery(sql, BookTransactionRecord.class);
        q.setParameter("isbn", isbn);
        q.setParameter("id", id);

        BookTransactionRecord btr = q.getSingleResult();

        java.util.Date currentDate = Calendar.getInstance().getTime();
        java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
        btr.setReturnDate(sqlDate);
    }
}
