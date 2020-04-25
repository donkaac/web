package com.sl.web.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sl.web.model.News;
import com.sl.web.model.ServiceProviderImages;
import com.sl.web.util.DataController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class ServiceProviderImagesServices {
    private DataController controller;

    public ServiceProviderImagesServices() {
        controller=new DataController();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        List<ServiceProviderImages> all =controller.getAll(ServiceProviderImages.class);
        return Response.ok().entity(all).build();

    }

    @POST
    @Path("/serviceproviderimages")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces(MediaType.TEXT_PLAIN)
    public Response add(String data) {

        JsonObject object = JsonParser.parseString(data).getAsJsonObject();

        String path = object.get("path").getAsString();
        byte isLogo = object.get("isLogo").getAsByte();

        ServiceProviderImages serviceProviderImages=new ServiceProviderImages(path,isLogo);
        boolean save = controller.save(serviceProviderImages);
        if (save) {
            return Response.ok().entity("true").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }
}
