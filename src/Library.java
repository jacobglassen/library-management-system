import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;


public class Library {
    private final List<Resource> resources = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();
    private final List<Loan> loans = new ArrayList<>();
    private final LoanPolicy loanPolicy;

    public Library(LoanPolicy loanPolicy) {
        this.loanPolicy = loanPolicy;
    }

    public void addMember(Member member) {
        members.add(member);
    }
    public void addResource(Resource resource){
        resources.add(resource);
    }
    public void removeResource(Resource resource){
        resources.remove(resource);
    }

    public List<Resource> getResources() {
        return resources;
    }

    public List<Member> getMembers() {
        return members;
    }

    public List<Loan> getLoans() {
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
        if (!(loanPolicy.canLoan(member, resource, loans))) return LoanResult.NOT_ALLOWED;
        for (Loan loan : loans){
            if (loan.getResource().getIdentifier() == bookId){
                return LoanResult.ALREADY_LOANED;
            }
        }
        LocalDate loanDate = LocalDate.now();
        LocalDate dueDate =loanPolicy.calculateDueDate(resource, loanDate);
        Loan loan = new Loan(resource, member, loanDate, dueDate);
        loans.add(loan);
        return LoanResult.SUCCESS;

    }
    public boolean returnBook(int bookId, int memberId){
        for (int i = 0; i < loans.size(); i++){
            Loan loan = loans.get(i);
            if (loan.getResource().getIdentifier() == bookId
                    && loan.getMember().memberId() == memberId) {

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
        AudioBook audioBook1 = new AudioBook(67, "Babadook", 500, "Dixen Myers");
        resources.add(book1);
        resources.add(movie1);
        resources.add(videoGame1);
        resources.add(audioBook1);

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

