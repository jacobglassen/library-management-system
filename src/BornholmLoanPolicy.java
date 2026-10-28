import java.time.LocalDate;
import java.util.List;

public class BornholmLoanPolicy implements LoanPolicy{
    @Override
    public boolean canLoan(Member member, Resource resource, List<Loan> loans) {
        return true;
    }

    @Override
    public LocalDate calculateDueDate(Resource resource, LocalDate loanDate) {
        if (resource instanceof AudioBook){
            return loanDate.plusDays(14);
        }
        return loanDate.plusDays(30);
    }
}
