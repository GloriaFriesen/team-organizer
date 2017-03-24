import org.junit.*;
import static org.junit.Assert.*;

public class TeamTest {

  @Test
  public void Team_instantiatesCorrectly_true() {
    Team myTeam = new Team("Team TOT");
    assertEquals(true, myTeam instanceof Team);
  }

  @Test
  public void Team_instantiatesWithDescription_String() {
    Team myTeam = new Team("Team TOT");
    assertEquals("Team TOT", myTeam.getName());
  }

}
