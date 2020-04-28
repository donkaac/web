package com.sl.web.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sl.web.model.DocumentImages;
import com.sl.web.model.News;
import com.sl.web.util.DataController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
@Path("/document_images")
public class DocumentImageServices {
    private DataController controller;

    public DocumentImageServices() {
        controller=new DataController();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        List<DocumentImageServices> all =controller.getAll(DocumentImageServices.class);
        return Response.ok().entity(all).build();

    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id) {
        DocumentImages documentImages = controller.getById(DocumentImages.class, id);
        return Response.status(200).entity(documentImages).build();
    }

    @POST
    @Path("/add")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces(MediaType.TEXT_PLAIN)
    public Response add(String data) {

        JsonObject object = JsonParser.parseString(data).getAsJsonObject();

        String path = object.get("path").getAsString();


        DocumentImages documentImages=new DocumentImages(path);
        boolean save = controller.save(documentImages);
        if (save) {
            return Response.ok().entity("true").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }
}
