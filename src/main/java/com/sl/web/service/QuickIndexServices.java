package com.sl.web.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sl.web.model.QuickIndex;
import com.sl.web.util.DataController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class QuickIndexServices {
    private DataController controller;

    public QuickIndexServices() {
        controller=new DataController();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        List<QuickIndex> all =controller.getAll(QuickIndex.class);
        return Response.ok().entity(all).build();

    }

    @POST
    @Path("/quickindex")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces(MediaType.TEXT_PLAIN)
    public Response add(String data) {

        JsonObject object = JsonParser.parseString(data).getAsJsonObject();

        String title = object.get("title").getAsString();
        String content = object.get("content").getAsString();

        QuickIndex quickIndex=new QuickIndex(title,content);
        boolean save = controller.save(quickIndex);
        if (save) {
            return Response.ok().entity("true").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }
}
