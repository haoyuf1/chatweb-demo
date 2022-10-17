package edu.rice.comp504.controller;

import com.google.gson.Gson;
import edu.rice.comp504.adapter.DispatchAdapter;

import java.awt.*;

import static spark.Spark.*;


/**
 * The paint world controller creates the adapter(s) that communicate with the view.
 * The controller responds to requests from the view after contacting the adapter(s).
 */
public class BallWorldController {

    /**
     * The main entry point into the program.
     * @param args  The program arguments normally specified on the cmd line
     */
    public static void main(String[] args) {
        staticFiles.location("/public");
        port(getHerokuAssignedPort());
        Gson gson = new Gson();
        DispatchAdapter dis = new DispatchAdapter();

        post("/load", (request, response) -> {
            return gson.toJson(dis.loadAObject(request.queryParams("strategy"), request.queryParams("inter_strategy"),
                request.queryParams("type"), Boolean.parseBoolean(request.queryParams("isSwitchable"))));
        });

        post("/switch", (request, response) -> {
            return gson.toJson(dis.switchStrategy(request.queryParams("strategy"), request.queryParams("inter_strategy")));
        });

        get("/update", (request, response) -> {
            return gson.toJson(dis.updateBallWorld());
        });

        post("/canvas/dims", (request, response) -> {
            dis.setCanvasDims(new Point((int) Integer.parseInt(request.queryParams("width")),
                (int) Integer.parseInt(request.queryParams("height"))));
            return gson.toJson("set canvas dimensions");
        });

        get("/remove/:type", (request, response) -> {
            return gson.toJson(dis.remove(request.params(":type")));
        });


        get("/clear", (request, response) -> {
            return gson.toJson(dis.removeAll());
        });

        redirect.get("/ballworld", "/");
        redirect.get("/*", "/");
    }

    /**
     * Get the heroku assigned port number.
     * @return The port number
     */
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
