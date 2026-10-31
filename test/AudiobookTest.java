import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AudiobookTest {
    private AudioBook audioBook;

    @BeforeEach
    void setup(){
        audioBook = new AudioBook(10, "Title", 100, "Creator");
    }
    @Test
    void testGetId(){
        int id = audioBook.getIdentifier();
        assertEquals(10, id);
    }
    @Test
    void testGetCreator(){
        String creator = audioBook.getCreator();
        assertEquals("Creator", creator);
    }
    @Test
    void testGetTitle(){
        String title = audioBook.getTitle();
        assertEquals("Title", title);
    }
    @Test
    void testGetDuration(){
        int duration = audioBook.getDuration();
        assertEquals(100, duration);
    }
}
