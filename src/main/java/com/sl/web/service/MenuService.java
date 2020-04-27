package com.sl.web.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sl.web.model.Comments;
import com.sl.web.model.Menu;
import com.sl.web.util.DataController;
import javafx.scene.chart.PieChart;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.List;

public class MenuService {
    private DataController controller;

    public MenuService() {
        controller=new DataController();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){

       List<Menu> all= controller.getAll(Menu.class);
       return Response.ok().entity(all).build();
    }

    @POST
    @Path("/menu")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.TEXT_PLAIN)
    public Response add(String data){
        JsonObject object = JsonParser.parseString(data).getAsJsonObject();
        String name = object.get("name").getAsString();


        Menu menu=new Menu(name);
        boolean save = controller.save(menu);
        if (save) {
            return Response.ok().entity("true").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }
    }





