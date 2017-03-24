import java.util.List;
import java.util.ArrayList;

public class Member {
  private String mName;
  private String mSkill;
  private static List<Member> instances = new ArrayList<Member>();
  private int mId;

  public Member(String name, String skill) {
    mName = name;
    mSkill = skill;
    instances.add(this);
    mId = instances.size();
  }

  public String getName() {
    return mName;
  }

  public String getSkill() {
    return mSkill;
  }

  public static List<Member> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public static Member find(int id) {
    return instances.get(id - 1);
  }

  public String getImage() {
    return String.format("<img src='/images/%d.jpeg'>", getId());
  }
}
