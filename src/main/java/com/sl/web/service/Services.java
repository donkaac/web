package com.sl.web.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sl.web.model.Service;
import com.sl.web.util.DataController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/services")
public class Services {
    private DataController controller;

    public Services() {
        controller = new DataController();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Service> all = controller.getAll(Service.class);
        return Response.ok().entity(all).build();

    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id) {
        Service service = controller.getById(Service.class, id);
        return Response.status(200).entity(service).build();
    }

    @POST
    @Path("/add")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces(MediaType.TEXT_PLAIN)
    public Response add(String data) {

        JsonObject object = JsonParser.parseString(data).getAsJsonObject();

        String name = object.get("name").getAsString();
        String content = object.get("content").getAsString();
        String slideShowImages = object.get("slideShowImages").getAsString();


        Service service = new Service(name, content, slideShowImages);
        boolean save = controller.save(service);
        if (save) {
            return Response.ok().entity("true").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }
}
