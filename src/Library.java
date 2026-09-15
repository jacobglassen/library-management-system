import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Loan> loans = new ArrayList<>();

    public void addBook(Book book){
        books.add(book);
    }
    public void addMember(Member member){
        members.add(member);
    }
    public ArrayList<Book> getBooks(){
        return books;
    }
    public ArrayList<Member> getMembers(){
        return members;
    }
    public ArrayList<Loan> getLoans(){
        return loans;
    }
    public void printBooks(){
        for (Book book : books){
            IO.println(book);
        }
    }
    public void printMembers(){
        for (Member member : members){
            IO.println(member);
        }
    }
}
