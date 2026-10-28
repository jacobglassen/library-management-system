import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;
    private Member member;
    private Book book;
    @BeforeEach
    void setup(){
        //Arrange
        library = new Library(new StandardLoanPolicy());
        member = new Member("Donald Trump", 1);
        book = new Book(9780, "Slaughterhouse Five", "Kurt Vonnegut", 475);
        library.addMember(member);
        library.addResource(book);
    }
    @Test
    void testLoanWithUnknownMember() {

        // Act
        LoanResult result = library.loanBook(9780, 22222);

        // Assert
        assertEquals(LoanResult.MEMBER_NOT_FOUND, result);
    }
    @Test
    void testLoanWhenBookIsNotAvailable() {


        // First loan succeeds
        library.loanBook(book.getIdentifier(), member.memberId());

        // Act
        LoanResult result = library.loanBook(book.getIdentifier(), member.memberId());

        // Assert
        assertEquals(LoanResult.ALREADY_LOANED, result);
    }
    @Test
    void testLoanWithUnknownBook(){


        //Act
        LoanResult result = library.loanBook(9999, member.memberId());

        //Assert
        assertEquals(LoanResult.MATERIAL_NOT_FOUND, result);
    }
    @Test
    void testSuccessfulLoan(){


        //Act
        LoanResult result = library.loanBook(book.getIdentifier(), member.memberId());

        //Assert
        assertEquals(LoanResult.SUCCESS, result);
    }

}
