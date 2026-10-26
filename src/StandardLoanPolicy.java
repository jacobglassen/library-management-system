import java.time.LocalDate;

public class StandardLoanPolicy implements LoanPolicy{

    @Override
    public boolean canLoan(Member member, Resource resource) {
        return true;
    }

    @Override
    public LocalDate calculateDueDate(Resource resource) {
        return LocalDate.now().plusDays(30);
    }
}