import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.List;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    //homepage
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("teams", request.session().attribute("teams"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //add team
    get("/teams/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/team-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //add team success page
    post("/teams", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    ArrayList<Team> teams = request.session().attribute("teams");
    if (teams == null) {
      teams = new ArrayList<Team>();
      request.session().attribute("teams", teams);
    }
    Team newTeam = new Team(request.queryParams("teamName"));
    teams.add(newTeam);
    model.put("template", "templates/success-team.vtl");
    return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //view all teams
    get("/teams", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("teams", Team.all());
      model.put("template", "templates/teams.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //view individual team
    get("/teams/:teams_id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Team team = Team.find(Integer.parseInt(request.params(":teams_id")));
      model.put("members", request.session().attribute("members"));
      // model.put("members", team.getMembers());
      model.put("team", team);
      model.put("template", "templates/team.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //add member
    get("/teams/:teams_id/members/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Team team = Team.find(Integer.parseInt(request.params(":teams_id")));
      request.session().attribute("team", team);
      model.put("team", team);
      model.put("template", "templates/member-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //add member success page
    post("/members", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Member newMember = new Member(request.queryParams("memberName"), request.queryParams("memberSkill"));
      Team team = request.session().attribute("team");
      team.addMember(newMember);

      ArrayList<Member> members = request.session().attribute("member");
      if (members == null) {
        members = new ArrayList<Member>();
        request.session().attribute("members", members);
      }
      members.add(newMember);

      model.put("team", team);
      model.put("member", newMember);
      model.put("template", "templates/member-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //view member
    get("/teams/:teams_id/members/:member_id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Team team = Team.find(Integer.parseInt(request.params(":teams_id")));
      Member member = Member.find(Integer.parseInt(request.params(":member_id")));
      model.put("member", member);
      model.put("team", team);
      model.put("template", "templates/member.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //info
    get("/info", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/info.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
