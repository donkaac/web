package com.sl.web.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sl.web.model.News;
import com.sl.web.model.PackageType;
import com.sl.web.util.DataController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
@Path("/package_types")
public class PackageTypeServices {
    private DataController controller;

    public PackageTypeServices() {
        controller=new DataController();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        List<PackageType> all =controller.getAll(PackageType.class);
        return Response.ok().entity(all).build();

    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id) {
        PackageType packageType = controller.getById(PackageType.class, id);
        return Response.status(200).entity(packageType).build();
    }

    @POST
    @Path("/add")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces(MediaType.TEXT_PLAIN)
    public Response add(String data) {

        JsonObject object = JsonParser.parseString(data).getAsJsonObject();

         String packageType=object.get("packageType").getAsString();
         String description=object.get("description").getAsString();
         Double price=object.get("price").getAsDouble();

         PackageType packageType1=new PackageType(packageType,description,price);

        boolean save = controller.save(packageType1);
        if (save) {
            return Response.ok().entity("true").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }
}
