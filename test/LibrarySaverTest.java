import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

public class LibrarySaverTest {

    @Test
    void testSaveMembers() throws IOException {

        // Arrange
        var members = List.of(
                new Member("Jørgen Leth", 1),
                new Member("Donald Trump", 2),
                new Member("Min Mor", 3)
        );

        var librarySaver = new LibrarySaver(new CsvMapper());

        // Act
        librarySaver.saveMembers(members, "test-members.csv");

        // Assert
        var expected = """
                Jørgen Leth,1
                Donald Trump,2
                Min Mor,3
                """;
        var actual = Files.readString(Path.of("test-members.csv"))
                .replace("\r\n", "\n");

        assertEquals(expected, actual);
//        var actual = Files.readString(Path.of("test-members.csv"));
//
//        assertEquals(expected, actual);
    }
    @Test
    void testSaveLoans() throws IOException {
        //Arrange
        Loan loan1 = new Loan(new Book(1, "Title", "Creator", 100), new Member("Jørgen Leth", 1), LocalDate.of(2000, 1, 1), LocalDate.of(2000, 1, 31));
        Loan loan2 = new Loan(new Book(2, "Title", "Creator", 100), new Member("Jørgen Leth", 2), LocalDate.of(2000, 1, 1), LocalDate.of(2000, 1, 31));
        var loans = List.of(loan1, loan2);
        var librarySaver = new LibrarySaver(new CsvMapper());
        //Act
        librarySaver.saveLoans(loans, "test-loans.csv");
        //Assert
        var expected = """
                1,1,2000-01-01,2000-01-31
                2,2,2000-01-01,2000-01-31
                """;
        var actual = Files.readString(Path.of("test-loans.csv"));
        assertEquals(expected, actual);
    }
    @Test void testSaveBooks() throws IOException {
        //Arrange
        var books = List.of(
                new Book(1, "Title", "Creator", 10),
                new Book(2, "Title", "Creator", 10),
                new Book(3, "Title", "Creator", 10)
        );
        var librarySaver = new LibrarySaver(new CsvMapper());
        //Act
        librarySaver.saveBooks(books, "test-books.csv");
    }
}