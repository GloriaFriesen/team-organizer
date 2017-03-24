import org.junit.*;
import static org.junit.Assert.*;

public class MemberTest {

  @Before
  public void tearDown() {
    Member.clear();
  }

  @Test
  public void Member_instantiatesCorrectly_true() {
    Member myMember = new Member("Abby", "dog");
    assertEquals(true, myMember instanceof Member);
  }

  @Test
  public void Member_instantiatesWithName_String() {
    Member myMember = new Member("Abby", "dog");
    assertEquals("Abby", myMember.getName());
  }

  @Test
  public void Member_instantiatesWithSkill_String() {
    Member myMember = new Member("Abby", "dog");
    assertEquals("dog", myMember.getSkill());
  }

  @Test
  public void Member_returnsAllInstancesOfMember_true() {
    Member firstMember = new Member("Abby", "dog");
    Member secondMember = new Member("Pepper Jack", "dog");
    assertEquals(true, Member.all().contains(firstMember));
    assertEquals(true, Member.all().contains(secondMember));
  }

  @Test
  public void clear_emptiesAllMembersFromList_0() {
    Member myMember = new Member("Abby", "dog");
    Member.clear();
    assertEquals(0, Member.all().size());
  }

  @Test
  public void getId_memberInstantiatesWithAnId_1() {
    Member myMember = new Member("Abby", "dog");
    assertEquals(1, myMember.getId());
  }

  @Test
  public void find_returnsMemberWithSameId_secondMember() {
    Member firstMember = new Member("Abby", "dog");
    Member secondMember = new Member("Pepper Jack", "dog");
    assertEquals(secondMember, Member.find(secondMember.getId()));
  }

  @Test
  public void getImage_returnsCorrectImageTag_String(){
    Member myMember = new Member("Abby", "dog");
    String imageTag = "<img src='/images/1.jpeg'>";
    assertEquals(imageTag, myMember.getImage());
  }
}
