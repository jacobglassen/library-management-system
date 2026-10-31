import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VideoGameTest {
    private VideoGame videoGame;
    @BeforeEach
    void setup(){
        //Arrange
        videoGame = new VideoGame(20, "Title", "Creator", "Platform");
    }
    @Test
    void testGetPlatform(){
        //Act
        String platform = videoGame.getPlatform();

        //Assert
        assertEquals("Platform", platform);
    }
    @Test
    void testGetId(){
        //Act
        int VGId = videoGame.getIdentifier();

        //Assert
        assertEquals(20, VGId);
    }
    @Test
    void testGetTitle() {
        //Act
        String title = videoGame.getTitle();

        //Assert
        assertEquals("Title", title);
    }
    @Test
    void testGetCreator(){
        //Act
        String creator = videoGame.getCreator();

        //Assert
        assertEquals("Creator", creator);
    }
}
