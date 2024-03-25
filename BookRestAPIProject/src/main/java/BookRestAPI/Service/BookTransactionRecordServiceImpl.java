package BookRestAPI.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import BookRestAPI.Dao.BookTransactionRecordDao;

@Service
public class BookTransactionRecordServiceImpl implements BookTransactionRecordService 
{
	private BookTransactionRecordDao bookTransactionRecordDao;
	
	@Autowired
	public BookTransactionRecordServiceImpl(@Qualifier("bookTransactionRecordDaoImpl") BookTransactionRecordDao bookTransactionRecordDao) {
		this.bookTransactionRecordDao = bookTransactionRecordDao;
	}
	
	@Override
	@Transactional
	public void BorrowBook(int isbn, int id) {
		bookTransactionRecordDao.BorrowBook(isbn, id);
	}

	@Override
	@Transactional
	public void ReturnBook(int isbn, int id) {
		bookTransactionRecordDao.ReturnBook(isbn, id);
	}

}
