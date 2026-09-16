import java.time.LocalDate;
import java.util.Objects;

public class Book {
    final String author;
    final String title;
    final String isbn;
    final int id;



    public Book(String author, String title, String isbn, int id) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.id = id;


    }
    public int getId(){
        return id;
    }


    public String toString(){
        return String.format("""
                %s: %s; ISBN %s (%d)""",
        author, title, isbn, id);
    }

    @Override
    public boolean equals(Object otherobj){
        if (otherobj == null || getClass() != otherobj.getClass()) return false;
        Book book = (Book) otherobj;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author) && id == book.id;
    }
    }


