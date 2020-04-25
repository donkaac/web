package com.sl.web.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sl.web.model.News;
import com.sl.web.model.Overview;
import com.sl.web.model.OverviewImages;
import com.sl.web.util.DataController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class OverviewImagesServices {

    private DataController controller;

    public OverviewImagesServices() {
        controller=new DataController();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        List<OverviewImages> all =controller.getAll(OverviewImages.class);
        return Response.ok().entity(all).build();

    }

    @POST
    @Path("/overviewimages")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces(MediaType.TEXT_PLAIN)
    public Response add(String data) {

        JsonObject object = JsonParser.parseString(data).getAsJsonObject();

        String path = object.get("path").getAsString();

       OverviewImages overviewImages=new OverviewImages(path);
        boolean save = controller.save(overviewImages);
        if (save) {
            return Response.ok().entity("true").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }
}
