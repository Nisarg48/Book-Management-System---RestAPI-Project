package BookRestAPI.Entities;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "isbn")
    private int isbn;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "genre")
    private String genre;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "year_of_published")
    private int yearofpublished;

    @Column(name = "isavailable")
    private int isAvailable = 1;

    @ManyToOne
    @JoinColumn(name = "sid")
    private Supplier supplier;

    public Books() {
        super();
    }

    public Books(int isbn, String title, String author, String genre, String publisher, int yearofpublished,
                 int isAvailable, Supplier supplier) {
        super();
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.yearofpublished = yearofpublished;
        this.isAvailable = isAvailable;
        this.supplier = supplier;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYearofpublished() {
        return yearofpublished;
    }

    public void setYearofpublished(int yearofpublished) {
        this.yearofpublished = yearofpublished;
    }

    public int getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(int isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Books [isbn=" + isbn + ", title=" + title + ", author=" + author + ", genre=" + genre + ", publisher="
                + publisher + ", yearofpublished=" + yearofpublished + ", isAvailable=" + isAvailable + ", supplier="
                + supplier + "]";
    }
}