import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MovieTest {
    private Movie movie;

    @BeforeEach
    void setup(){
        movie = new Movie(10, "Title", "Creator", "Director", 50.35);
    }
    @Test
    void testGetId(){
        int id = movie.getIdentifier();
        assertEquals(10, id);
    }
    @Test
    void testGetTitle(){
        String title = movie.getTitle();
        assertEquals("Title", title);
    }
    @Test
    void testGetCreator(){
        String creator = movie.getCreator();
        assertEquals("Creator", creator);
    }
    @Test
    void testGetDirector(){
        String director = movie.getDirector();
        assertEquals("Director", director);
    }
    @Test
    void testGetLength(){
        double length = movie.getLength();
        assertEquals(50.35, length);
    }
}
