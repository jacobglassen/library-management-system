import java.time.LocalDate;

public class Loan {
    final Resource resource;
    final Member member;
    final LocalDate borrowedDate;
    private final LocalDate dueDate;

    public Loan(Resource resource, Member member, LocalDate borrowedDate, LocalDate dueDate){
        this.resource = resource;
        this.member = member;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
    }

    public Resource getResource(){
        return resource;
    }
    public Member getMember(){
        return member;
    }
    public LocalDate getDueDate(){
        return dueDate;
    }
    public boolean isOverdue(){
        return LocalDate.now().isAfter(getDueDate());
    }
    public String toString(){
        return (getResource() + "\n" + getMember() + "\n" + "afleveringsfrist " + getDueDate() + "\n");
    }
}
