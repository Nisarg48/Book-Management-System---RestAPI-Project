package BookRestAPI.Dao;

public interface BookTransactionRecordDao 
{
	public void BorrowBook(int isbn, int id);
	
	public void ReturnBook(int isbn, int id);
}
