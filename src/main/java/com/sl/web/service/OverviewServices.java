package com.sl.web.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sl.web.model.News;
import com.sl.web.model.Overview;
import com.sl.web.util.DataController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class OverviewServices {

    private DataController controller;

    public OverviewServices() {
        controller=new DataController();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        List<Overview> all =controller.getAll(Overview.class);
        return Response.ok().entity(all).build();

    }

    @POST
    @Path("/overview")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces(MediaType.TEXT_PLAIN)
    public Response add(String data) {

        JsonObject object = JsonParser.parseString(data).getAsJsonObject();

        String title =object.get("title").getAsString();
         String subtitle=object.get("subtitle").getAsString();
         String mainImage=object.get("mainImage").getAsString();
         String link=object.get("link").getAsString();
         String content=object.get("content").getAsString();
         String subOverview=object.get("subOverview").getAsString();

        Overview overview = new Overview(title,subtitle,mainImage,link,content,subOverview);
        boolean save = controller.save(overview);
        if (save) {
            return Response.ok().entity("true").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }
}
