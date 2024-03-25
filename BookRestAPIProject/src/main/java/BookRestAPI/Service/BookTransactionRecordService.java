package BookRestAPI.Service;

public interface BookTransactionRecordService 
{
	public void BorrowBook(int isbn, int id);
	
	public void ReturnBook(int isbn, int id);
}
