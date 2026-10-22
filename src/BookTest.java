import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    public void testGetCreator(){
        Book book = new Book (123,
                "Harry Potter", "J.K. Rowling", 500);
        assertEquals("J.K. Rowling", book.getCreator());

    }
    @Test
    public void testGetID(){
        Book book = new Book (123,
                "Harry Potter", "J.K. Rowling", 500);
        assertEquals(123, book.getIdentifier());
    }
    @Test
    public void testGetTitle(){
        Book book = new Book (123,
                "Harry Potter", "J.K. Rowling", 500);
        assertEquals("Harry Potter", book.getTitle());
    }
    @Test
    public void testGetPages(){
        Book book = new Book (123,
                "Harry Potter", "J.K. Rowling", 500);
        assertEquals(500, book.getPages());
    }
    @Test
    public void testSetCreator(){
        Book book = new Book (123,
                "Harry Potter", "J.K. Rowling", 500);
        book.setCreator("George Washington");
        assertEquals("George Washington", book.getCreator());
    }
}