import org.junit.*;
import static org.junit.Assert.*;

public class TeamTest {

  @Before
  public void tearDown() {
    Team.clear();
  }

  @Test
  public void Team_instantiatesCorrectly_true() {
    Team myTeam = new Team("Team TOT");
    assertEquals(true, myTeam instanceof Team);
  }

  @Test
  public void Team_instantiatesWithName_String() {
    Team myTeam = new Team("Team TOT");
    assertEquals("Team TOT", myTeam.getName());
  }

  @Test
  public void all_returnsAllInstancesOfTeam_true() {
    Team firstTeam = new Team("Team TOT");
    Team secondTeam = new Team("A Team");
    assertEquals(true, Team.all().contains(firstTeam));
    assertEquals(true, Team.all().contains(secondTeam));
  }

  @Test
  public void clear_emptiesAllTeamFromList_0() {
    Team myTeam = new Team("Team TOT");
    Team.clear();
    assertEquals(0, Team.all().size());
  }

  @Test
  public void getId_teamInstantiatesWithAnId_1() {
    Team myTeam = new Team("Team Tot");
    assertEquals(1, myTeam.getId());
  }

  @Test
  public void find_returnsTeamWithSameId_secondTeam() {
    Team firstTeam = new Team("Team TOT");
    Team secondTeam = new Team("A Team");
    assertEquals(secondTeam, Team.find(secondTeam.getId()));
  }

  @Test
  public void getMembers_initiallyReturnsEmptyList_ArrayList() {
    Team myTeam = new Team("Team TOT");
    assertEquals(0, myTeam.getMembers().size());
  }

  @Test
  public void addMember_addsMemberToList_true() {
    Team myTeam = new Team("Team TOT");
    Member myMember = new Member("Abby", "dog");
    myTeam.addMember(myMember);
    assertTrue(myTeam.getMembers().contains(myMember));
  }
}
