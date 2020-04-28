package com.sl.web.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sl.web.model.ServiceProvider;
import com.sl.web.util.DataController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
@Path("/service_provider")
public class ServiceProviderServises {
    private DataController controller;

    public ServiceProviderServises() {
        controller=new DataController();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        List<ServiceProvider> all =controller.getAll(ServiceProvider.class);
        return Response.ok().entity(all).build();

    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id) {
        ServiceProvider serviceProvider = controller.getById(ServiceProvider.class, id);
        return Response.status(200).entity(serviceProvider).build();
    }

    @POST
    @Path("/add")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces(MediaType.TEXT_PLAIN)
    public Response add(String data) {

        JsonObject object = JsonParser.parseString(data).getAsJsonObject();

   String name=object.get("name").getAsString();
        String description=object.get("description").getAsString();
        String address=object.get("address").getAsString();
        String phone1=object.get("phone1").getAsString();
        String phone2=object.get("phone2").getAsString();
        String email=object.get("email").getAsString();
      //  Integer serviceId=object.get("serviceId").getAsInt();


        ServiceProvider serviceProvider=new ServiceProvider(name,description,address,phone1,phone2,email);
        boolean save = controller.save(serviceProvider);
        if (save) {
            return Response.ok().entity("true").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }
}
