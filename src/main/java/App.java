import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import models.Hero;
import models.Squads;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;


public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");



        //get method for displaying a new Hero form
        get("/heroes/newHero", (req,res)->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());
        //post method to process new Hero form
        post("/heroes/newHero", (request, response) -> { //URL to make new hero on POST route
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String heroPower = request.queryParams("heroPower");
            String weakness = request.queryParams("weakness");
            Hero newHero = new Hero(name,age,heroPower,weakness);
            model.put("hero", newHero);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        /

        //get method taht displays the specific hero based on the id of  individual Hero
        get("/heroes/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToFind = Integer.parseInt(req.params(":id")); //pull id - must match route segment
            Hero heroFound = Hero.findById(idOfHeroToFind); //use it to find hero
            model.put("hero", heroFound); //add it to model for template to display
            return new ModelAndView(model, "hero-detail.hbs"); //individual post page.
        }, new HandlebarsTemplateEngine());
        //get: show a form to update a Hero
        get("/heroes/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToEdit = Integer.parseInt(req.params("id"));
            Hero editHero = Hero.findById(idOfHeroToEdit);
            model.put("editHero", editHero);
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());
        //post method to send updated form data to the server to update a Hero
        post("/heroes/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String newName = req.queryParams("name");
            int newAge = Integer.parseInt(req.queryParams("age"));
            String newPower = req.queryParams("heroPower");
            String newWeakness = req.queryParams("weakness");
            int idOfHeroToEdit = Integer.parseInt(req.params("id"));
            Hero editHero = Hero.findById(idOfHeroToEdit);
            editHero.update(newName,newAge,newPower,newWeakness);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
        //get method to delete a hero based on the id of the individual Hero
        get("/heroes/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToDelete = Integer.parseInt(req.params("id")); //the id should match route segment
            Hero deleteHero = Hero.findById(idOfHeroToDelete); //use it to find the spec hero
            deleteHero.deleteHero();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

//        Squad section



        //get method : to display new squad form
        get("/squads/newSquads", (req,res)->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squads-form.hbs");
        }, new HandlebarsTemplateEngine());
        //squad post method to update squad data in the server from the form
        post("/squads/newSquads", (request, response) -> { //URL to make new hero on Squad route
            Map<String, Object> model = new HashMap<>();
            String squadName = request.queryParams("squadName");
            int maxSize = Integer.parseInt(request.queryParams("maxSize"));
            String cause = request.queryParams("cause");
            Squads newSquad = new Squads(squadName,maxSize,cause);
            model.put("squad", newSquad);
            return new ModelAndView(model, "squadsSuccess.hbs");
        }, new HandlebarsTemplateEngine());

        //get method to display all Squads
        get("/squads/squadsList", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squads> allSquads = Squads.getAll();
            model.put("squads", allSquads);

            return new ModelAndView(model, "squads.hbs");
        }, new HandlebarsTemplateEngine());

        //get method to display an individual Squad
        get("/squads/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfSquadToFind = Integer.parseInt(req.params(":id")); //pull id - must match route segment
            Squads foundSquad = Squads.findById(idOfSquadToFind); //use it to find post
            model.put("squad", foundSquad); //add it to model for template to display
            return new ModelAndView(model, "squad-details.hbs"); //individual post page.
        }, new HandlebarsTemplateEngine());
        //get method to present the form for updating a squad based on the id
        get("/squads/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfSquadToEdit = Integer.parseInt(req.params("id"));
            Squads editSquad = Squads.findById(idOfSquadToEdit);
            model.put("editSquad", editSquad);
            return new ModelAndView(model, "squads-form.hbs");
        }, new HandlebarsTemplateEngine());
        //post method to process a form to update a squad
        post("/squads/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String newSquadName = req.queryParams("squadName");
            int newMaxSize = Integer.parseInt(req.queryParams("maxSize"));
            String newCause = req.queryParams("cause");
            int idOfSquadToEdit = Integer.parseInt(req.params("id"));
            Squads editSquad= Squads.findById(idOfSquadToEdit);
            editSquad.update(newSquadName,newMaxSize,newCause); //don’t forget me
            return new ModelAndView(model, "squadsSuccess.hbs");
        }, new HandlebarsTemplateEngine());
        //get method to delete a Hero based on the id
        get("/squads/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfSquadToDelete = Integer.parseInt(req.params("id")); //pull id must match route segment
            Squads deleteSquad = Squads.findById(idOfSquadToDelete); //use it to find post
            deleteSquad.deleteSquad();
            return new ModelAndView(model, "squadsSuccess.hbs");
        }, new HandlebarsTemplateEngine());
    }



}

