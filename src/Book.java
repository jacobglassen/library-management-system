import java.time.LocalDate;

public class Book {
    final String author;
    final String title;
    final String isbn;
    final int id;
    Member borrowedBy;
    LocalDate borrowedDate;


    public Book(String author, String title, String isbn, int id) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.id = id;
        this.borrowedBy = null;
        this.borrowedDate = null;

    }
    public boolean isAvailable(){
        return borrowedBy == null;
    }
    public boolean loanBook(Member member){
        if (borrowedBy == null){
            borrowedBy = member;
            borrowedDate = LocalDate.now();
            return true;
        } else {
            return false;
        }
    }
    public LocalDate getDueDate(){
        if (borrowedDate != null){
            return borrowedDate.plusDays(14);
        } else {
            return null;
        }
    }
    public void returnBook(){
        if (borrowedBy != null){
            borrowedBy = null;
            borrowedDate = null;
        }



    }
    public String toString(){
//        if (isAvailable){
//            return String.format("""
//                    %s: %s; ISBN: %s; %d - På hylden
//                    """, author, title, isbn, id);
//        }
//        String status = isAvailable ? "Ledig" : "Ikke ledig";
        if (borrowedBy != null){
        return String.format("""
                %s: %s; ISBN: %s; %d
                %s
                afleveringsfrist: %s""",
                author, title, isbn, id, borrowedBy, getDueDate());
    } else {
            return String.format("""
                    %s: %s; ISBN: %s; %d
                    """,
                    author, title, isbn, id);
        }
}}
