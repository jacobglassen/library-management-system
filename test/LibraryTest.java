import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    @Test
    void testLoanWithUnknownMember() {
        // Arrange
        Library library = new Library();
        Member member = new Member("Donald Trump", 1);
        Book book = new Book(9780, "Slaughterhouse Five", "Kurt Vonnegut", 475);

        library.addResource(book);

        // Act
        LoanResult result = library.loanBook(book.getIdentifier(), member.memberId());

        // Assert
        assertEquals(LoanResult.MEMBER_NOT_FOUND, result);
    }
}
