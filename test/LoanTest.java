import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;


public class LoanTest {
    private Member member;
    private Library library;
    private Book book;
    private LocalDate loanDate;
    private LocalDate dueDate;
//    private List<Loan> loans;

    @BeforeEach
    void setup(){
        //Arrange
        member = new Member("Name", 20);
        library = new Library(new StandardLoanPolicy());
        book = new Book(10, "Title", "Creator", 100);
        loanDate = LocalDate.of(2000, 1, 1);
        dueDate = LocalDate.of(2000, 1, 31);
//        List<Loan> loans = new ArrayList<>();
        library.addResource(book);
        library.addMember(member);
    }
    @Test
    void testGetMember(){
        //Act
//        library.loanResource(10, 20);
        Loan loan = new Loan(book, member, loanDate, dueDate);

        //Assert
        assertEquals(member, loan.getMember());
    }
    @Test
    void testGetResource(){
        //Act
        Loan loan = new Loan(book, member, loanDate, dueDate);

        //Assert
        assertEquals(book, loan.getResource());
    }
    @Test
    void testGetDueDate(){
        //Act
        Loan loan = new Loan(book, member, loanDate, dueDate);

        //Assert
        assertEquals(dueDate, loan.getDueDate());
    }
}
