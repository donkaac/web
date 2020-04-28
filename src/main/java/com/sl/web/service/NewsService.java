package com.sl.web.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sl.web.model.Comments;
import com.sl.web.model.News;
import com.sl.web.util.DataController;

import java.util.List;
import javax.enterprise.inject.New;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/news")
public class NewsService {
    private DataController controller;

    public NewsService() {
        controller=new DataController();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        List<News> all =controller.getAll(News.class);
        return Response.ok().entity(all).build();

    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id) {
        News news = controller.getById(News.class, id);
        return Response.status(200).entity(news).build();
    }

    @POST
    @Path("/add")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces(MediaType.TEXT_PLAIN)
    public Response add(String data) {

        JsonObject object = JsonParser.parseString(data).getAsJsonObject();

        String title = object.get("title").getAsString();
        String content = object.get("content").getAsString();

        News news = new News(title, content);
        boolean save = controller.save(news);
        if (save) {
            return Response.ok().entity("true").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }
}
