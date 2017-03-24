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
}
