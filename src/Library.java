import java.util.ArrayList;
import java.time.LocalDate;


public class Library {
    private ArrayList<Resource> resources = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Loan> loans = new ArrayList<>();

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
    public LoanResult loanBook(int bookId, int memberId){
        Resource resource = getBook(bookId);
        Member member = getMemberId(memberId);
        if (resource == null) return LoanResult.MATERIAL_NOT_FOUND;
        if (member == null) return LoanResult.MEMBER_NOT_FOUND;
        for (Loan loan : loans){
            if (loan.getResource().getIdentifier() == bookId){
                return LoanResult.ALREADY_LOANED;
            }
        }
        Loan loan = new Loan(resource, member, LocalDate.now());
        loans.add(loan);
        return LoanResult.SUCCESS;

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
    public void createResource(){
        Book book1 = new Book(9780, "Slaughterhouse Five", "Kurt Vonnegut", 475);
        Movie movie1 = new Movie(20, "Human Centipede", "MF Studios", "Mads Frahm", 120.20);
        VideoGame videoGame1 = new VideoGame(50, "abc", "def", "fld,sæfs");
        resources.add(book1);
        resources.add(movie1);
        resources.add(videoGame1);

    }
    public void createMembers(){
        Member member1 = new Member("Donald Trump", 1);
        Member member2 = new Member("Jørgen Leth", 2);
        Member member3 = new Member("Pelle Dragsted", 3);

        members.add(member1);
        members.add(member2);
        members.add(member3);
    }

}

