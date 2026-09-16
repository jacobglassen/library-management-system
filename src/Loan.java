import java.time.LocalDate;

public class Loan {
    final Book book;
    final Member member;
    final LocalDate borrowedDate;

    public Loan(Book book, Member member, LocalDate borrowedDate){
        this.book = book;
        this.member = member;
        this.borrowedDate = borrowedDate;
    }

    public Book getBook(){
        return book;
    }
    public Member getMember(){
        return member;
    }
    public LocalDate getDueDate(){
        return borrowedDate.plusDays(14);
    }
    public boolean isOverdue(){
        return LocalDate.now().isAfter(getDueDate());
    }
    public String toString(){
        return (getBook() + "\n" + getMember() + "\n" + "afleveringsfrist " + getDueDate() + "\n");
    }
}
