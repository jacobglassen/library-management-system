import java.util.ArrayList;
import java.time.LocalDate;


public class Library {
//    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Resource> resources = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Loan> loans = new ArrayList<>();

//    public void addBook(Book book) {
//        books.add(book);
//    }

    public void addMember(Member member) {
        members.add(member);
    }
    public void addResource(Resource resource){
        resources.add(resource);
    }
    public void removeResource(Resource resource){
        resources.remove(resource);
    }

    public ArrayList<Resource> getResources() {
        return resources;
    }

//    public ArrayList<Book> getBooks() {
//        return books;
//    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public void printBooks() {
        for (Resource resource : resources) {
            if (resource instanceof Book){
            IO.println(resource);
        }}
    }
    public Resource getBook(int bookId){
        for (Resource resource : resources){
            if (resource.getIdentifier() == bookId){
                return resource;
            }
        } return null;
    }
    public Member getMemberId(int memberId){
        for (Member member : members){
            if (member.memberId() == memberId){
                return member;
            }
        } return null;
    }
    public boolean loanBook(int bookId, int memberId){
        Resource resource = getBook(bookId);
        Member member = getMemberId(memberId);
        if (resource == null || member == null) return false;
        for (Loan loan : loans){
            if (loan.getResource().getIdentifier() == bookId){
                return false;
            }
        }
        Loan loan = new Loan(resource, member, LocalDate.now());
        loans.add(loan);
        return true;

    }
    public boolean returnBook(int bookId){
        Resource resource = getBook(bookId);
        if (resource == null) return false;
        for (int i = 0; i < loans.size(); i++){
            if (loans.get(i).getResource().getIdentifier() == bookId){
                loans.remove(i);
                return true;

            }
        }
        return false;
    }
    public ArrayList<Loan> findLoansByMemberId(int memberId){
        ArrayList<Loan> memberLoans = new ArrayList<Loan>();
        for (Loan loan : loans){
            if (loan.getMember().memberId() == memberId){
                memberLoans.add(loan);
            }
        }
        return memberLoans;
    }

    public void printMembers() {
        for (Member member : members) {
            IO.println(member);
        }
    }


}

