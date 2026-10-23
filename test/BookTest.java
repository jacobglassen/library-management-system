import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    @Test
    void testGetCreator(){
        //Arrange
        Book book = new Book(9780, "Slaughterhouse Five", "Kurt Vonnegut", 475);
        //Act
        String Creator = book.getCreator();
        //Assert
        assertEquals("Kurt Vonnegut", Creator);
    }
    @Test
    void testMovieDirector(){
        //Arrange
        Movie movie = new Movie(20, "Human Centipede", "MF Studios", "Mads Frahm", 120.20);
        //Act
        String Director = movie.director;
        //Assert
        assertEquals("Mads Frahm", Director);
    }
    @Test
    void testVideoGamePlatform(){
        //Arrange
        VideoGame videoGame = new VideoGame(50, "Grand Theft Auto 6 ", "Sam Houser", "Play Station");
        //Act
        String Platform = videoGame.platform;
        //Assert
        assertEquals("Play Station", Platform);
    }
}
