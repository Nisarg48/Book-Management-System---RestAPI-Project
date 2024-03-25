package BookRestAPI.Entities;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="book_transaction_records")
public class BookTransactionRecord 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tid")
	private int tid;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="uid")
	private User user; 
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="isbn")
	private Books book;
	
	@Column(name="borrow_date")
	@Temporal(TemporalType.DATE)
	private Date borrowDate;
	
	@Column(name="return_date")
	@Temporal(TemporalType.DATE)
	private Date returnDate;

	public BookTransactionRecord() {
		super();
	}

	public BookTransactionRecord(int tid, User user, Books book, Date borrowDate, Date returnDate) {
		super();
		this.tid = tid;
		this.user = user;
		this.book = book;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Books getBook() {
		return book;
	}

	public void setBook(Books book) {
		this.book = book;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "BookTransactionRecord [tid=" + tid + ", user=" + user + ", book=" + book + ", borrowDate=" + borrowDate
				+ ", returnDate=" + returnDate + "]";
	}
}
