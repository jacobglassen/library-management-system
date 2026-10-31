import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MemberTest {

    @Test
    void testGetName(){
        //Arrange
        Member member = new Member("NameTest", 20);
        //Act
        String name = member.name();
        //Assert
        assertEquals("NameTest", name);
    }

    @Test
    void testGetMemberId(){
        //Arrange
        Member member = new Member("NameTest", 20);
        //Act
        int memberId = member.memberId();
        //Assert
        assertEquals(20, memberId);
    }
}
