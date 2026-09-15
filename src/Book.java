import java.time.LocalDate;

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
    public String toString(){
        return String.format("""
                %s: %s; ISBN %s (%d)""",
        author, title, isbn, id);
    }
    }


