import java.util.List;
import java.util.ArrayList;

public class Member {
  private String mName;
  private static List<Member> instances = new ArrayList<Member>();

  public Member(String name) {
    mName = name;
    instances.add(this);
  }

  public String getName() {
    return mName;
  }

  public static List<Member> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }
}
