import java.time.LocalDate;
import java.util.List;

public class AarlborgLoanPolicy implements LoanPolicy{
    @Override
    public boolean canLoan(Member member, Resource resource, List<Loan> loans) {
        int count = 0;
        for (Loan loan : loans){
            if ((loan.getMember().memberId() == member.memberId()) &&
                    (loan.getResource() instanceof Movie) || (loan.getResource() instanceof VideoGame)){
                count++;
            }
        }
        return count < 3;
    }

    @Override
    public LocalDate calculateDueDate(Resource resource, LocalDate loanDate) {
        return loanDate.plusDays(30);
    }
}
