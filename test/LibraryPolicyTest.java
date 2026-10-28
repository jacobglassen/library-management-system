import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryPolicyTest {
    private Library library;
    private Member member;
    private Book book;
    private TestDoubleLoanPolicy testDouble;
    @BeforeEach
    void setup(){
        //Arrange
        testDouble = new TestDoubleLoanPolicy();
        library = new Library(testDouble);
        member = new Member("Donald Trump", 1);
        book = new Book(9780, "Slaughterhouse Five", "Kurt Vonnegut", 475);
        library.addResource(book);
        library.addMember(member);
    }
    @Test
    void testLibraryCallsCanLoan(){
        //Act
        LoanResult result = library.loanResource(9780, 1);
        boolean canLoanIsCalled = testDouble.canLoanCalled;

        //Assert
        assertEquals(LoanResult.SUCCESS, result);
        assertTrue(canLoanIsCalled);
    }
    @Test
    void testAarlborgPolicy(){
        //Arrange
        AarlborgLoanPolicy aarlborgLoanPolicy = new AarlborgLoanPolicy();
        Library library1 = new Library(aarlborgLoanPolicy);
        Movie m1 = new Movie(1, "1", "1", "1", 2);
        Movie m2 = new Movie(2, "1", "1", "1", 2);
        Movie m3 = new Movie(3, "1", "1", "1", 2);
        VideoGame vg1 = new VideoGame(4, "2", "2", "2");
        library1.addMember(member);
        library1.addResource(m1);
        library1.addResource(m2);
        library1.addResource(m3);
        library1.addResource(vg1);

        //Act
        assertEquals(LoanResult.SUCCESS, library1.loanResource(1,1));
        assertEquals(LoanResult.SUCCESS, library1.loanResource(2,1));
        assertEquals(LoanResult.SUCCESS, library1.loanResource(3,1));
        assertEquals(LoanResult.NOT_ALLOWED, library1.loanResource(4,1));
    }
    @Test
    void testCanLoanBornholmPolicy(){
        //Arrange
        BornholmLoanPolicy bornholmLoanPolicy = new BornholmLoanPolicy();
        Library library2 = new Library(bornholmLoanPolicy);
        library2.addMember(member);
        library2.addResource(book);
        List<Loan> loans = List.of();

        //Act
        boolean result = bornholmLoanPolicy.canLoan(member, book, loans);

        //Assert
        assertTrue(result);
    }
    @Test
    void testCalculateDateBornholmPolicy(){
        //Arrange
        BornholmLoanPolicy bornholmLoanPolicy = new BornholmLoanPolicy();
        Library library2 = new Library(bornholmLoanPolicy);
        AudioBook audioBook = new AudioBook(5, "21", 2, "21");
        library2.addMember(member);
        library2.addResource(book);

        LocalDate loanDate = LocalDate.of(2000,1,1);

        //Act
        LocalDate bookDueDate = bornholmLoanPolicy.calculateDueDate(book, loanDate);
        LocalDate audiobookDueDate = bornholmLoanPolicy.calculateDueDate(audioBook, loanDate);

        //Assert
        assertEquals(LocalDate.of(2000,1,15), audiobookDueDate);
        assertEquals(LocalDate.of(2000,1,31), bookDueDate);
    }
}
