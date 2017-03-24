import org.junit.*;
import static org.junit.Assert.*;

public class MemberTest {

  @Test
  public void Member_instantiatesCorrectly_true() {
    Member myMember = new Member("Abby");
    assertEquals(true, myMember instanceof Member);
  }

  @Test
  public void Member_instantiatesWithName_String() {
    Member myMember = new Member("Abby");
    assertEquals("Abby", myMember.getName());
  }

  @Test
  public void Member_returnsAllInstancesOfMember_true() {
    Member firstMember = new Member("Abby");
    Member secondMember = new Member("Pepper Jack");
    assertEquals(true, Member.all().contains(firstMember));
    assertEquals(true, Member.all().contains(secondMember));
  }

  @Test
  public void clear_emptiesAllMembersFromList_0() {
    Member myMember = new Member("Abby");
    Member.clear();
    assertEquals(0, Member.all().size());
  }
}
