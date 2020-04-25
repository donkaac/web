package com.sl.web.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sl.web.constant.Secured;
import com.sl.web.model.Menu;
import com.sl.web.model.NewsImages;
import com.sl.web.model.User;
import com.sl.web.util.DataController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class NewsImageServices {
    private DataController controller;

    public NewsImageServices () {
        controller=new DataController();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){

        List<NewsImages> all= controller.getAll(NewsImages.class);
        return Response.ok().entity(all).build();
    }

    @POST
    @Path("/newsimages")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.TEXT_PLAIN)
    public Response add(String data){
        JsonObject object = JsonParser.parseString(data).getAsJsonObject();
        String name = object.get("path").getAsString();

        NewsImages newsImages=new NewsImages(name);
        boolean save = controller.save(newsImages);
        if (save) {
            return Response.ok().entity("path").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }
}
