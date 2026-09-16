import java.util.ArrayList;
import java.time.LocalDate;


public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Loan> loans = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public void printBooks() {
        for (Book book : books) {
            IO.println(book);
        }
    }
    public Book getBook(int bookId){
        for (Book book : books){
            if (book.getId() == bookId){
                return book;
            }
        } return null;
    }
    public Member getMemberId(int memberId){
        for (Member member : members){
            if (member.getId() == memberId){
                return member;
            }
        } return null;
    }
    public boolean loanBook(int bookId, int memberId){
        Book book = getBook(bookId);
        Member member = getMemberId(memberId);
        if (book == null || member == null) return false;
        for (Loan loan : loans){
            if (loan.getBook().getId() == bookId){
                return false;
            }
        }
        Loan loan = new Loan(book, member, LocalDate.now());
        loans.add(loan);
        return true;

    }
    public boolean returnBook(int bookId){
        Book book = getBook(bookId);
        if (book == null) return false;
        for (int i = 0; i < loans.size(); i++){
            if (loans.get(i).getBook().getId() == bookId){
                loans.remove(i);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    public ArrayList<Loan> findLoansByMemberId(int memberId){
        ArrayList<Loan> memberLoans = new ArrayList<Loan>();
        for (Loan loan : loans){
            if (loan.getMember().getId() == memberId){
                memberLoans.add(loan);
            }
        } return memberLoans;
    }

    public void printMembers() {
        for (Member member : members) {
            IO.println(member);
        }
    }


}

