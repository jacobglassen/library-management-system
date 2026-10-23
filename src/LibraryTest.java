import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library library;
    private Book book;
    private Member member;

    @BeforeEach
    void setUp() {
        library = new Library();
        book = new Book(123, "Harry Potter", "J.K. Rowling", 500);
        member = new Member("Matt", 1);
        library.addMember(member);
        library.addResource(book);
    }
    @Test
    public void testValidLoan() {
        LoanResult result = library.loanBook(123, 1);

        assertEquals(LoanResult.SUCCESS, result);
        assertEquals(1, library.getLoans().size());
    }
    @Test
    public void testUnkownResource() {
        LoanResult result = library.loanBook(999, 1);

        assertEquals(LoanResult.MATERIAL_NOT_FOUND, result);
        assertTrue(library.getLoans().isEmpty());
    }
    @Test
    public void testUnkownMember() {
        LoanResult result = library.loanBook(123, 999);

        assertEquals(LoanResult.MEMBER_NOT_FOUND, result);
        assertTrue(library.getLoans().isEmpty());
    }
    @Test
    public void testAlreadyLoaned() {
        library.loanBook(123, 1);

        LoanResult result = library.loanBook(123, 1);

        assertEquals(LoanResult.ALREADY_LOANED, result);
        assertEquals(1, library.getLoans().size());
    }
    @Test
    public void testLoansAfterReturn() {
        library.loanBook(123, 1);
        library.returnBook(123, 1);

        LoanResult result = library.loanBook(123, 1);

        assertEquals(LoanResult.SUCCESS, result);
        assertEquals(1, library.getLoans().size());
    }
    @Test
    public void testValidReturn() {
        library.loanBook(123, 1);

        boolean result = library.returnBook(123, 1);

        assertTrue(result);
        assertTrue(library.getLoans().isEmpty());
    }
    @Test
    public void testReturnWithoutLoan() {
        boolean result = library.returnBook(123, 1);

        assertFalse(result);
        assertTrue(library.getLoans().isEmpty());
    }
    @Test
    public void testFailReturnNoChange() {
        library.loanBook(123, 1);
        Loan originalLoan = library.getLoans().get(0);
        boolean result = library.returnBook(999, 1);

        assertFalse(false);
        assertEquals(1, library.getLoans().size());
        assertSame(originalLoan, library.getLoans().get(0));
    }
    @Test
    public void testReturnWrongMember() {
        library.loanBook(123, 1);
        boolean result = library.returnBook(123, 999);

        assertFalse(result);
        assertEquals(1, library.getLoans().size());
    }

}