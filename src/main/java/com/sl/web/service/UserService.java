package com.sl.web.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sl.web.constant.Secured;
import com.sl.web.util.DataController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sl.web.model.*;



@Path("/user")
public class UserService {
    private DataController controller;

    public UserService() {
        controller = new DataController();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<User> all = controller.getAll(User.class);
        return Response.status(200).entity(all).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id) {
        User user = controller.getById(User.class, id);
        return Response.status(200).entity(user).build();
    }

    @POST
    @Path("/add")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces(MediaType.TEXT_PLAIN)
    public Response add(String data) {

        JsonObject object = JsonParser.parseString(data).getAsJsonObject();

        String name = object.get("name").getAsString();
        String email = object.get("email").getAsString();

        User user = new User(name, email, email);
        boolean save = controller.save(user);
        if (save) {
            return Response.ok().entity("true").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }

}
