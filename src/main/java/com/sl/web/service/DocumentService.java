package com.sl.web.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sl.web.model.Comments;
import com.sl.web.model.Document;
import com.sl.web.model.Menu;
import com.sl.web.util.DataController;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class DocumentService {
private DataController controller;

    public DocumentService() {
        controller=new DataController();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        List<Document> all= controller.getAll(Document.class);
        return Response.ok().entity(all).build();
    }

    @POST
    @Path("/document")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces(MediaType.TEXT_PLAIN)
    public Response add(String data) {

        JsonObject object = JsonParser.parseString(data).getAsJsonObject();

        String content = object.get("content").getAsString();
        Integer menuId = object.get("menuId").getAsInt();

        Document document = new Document(content,menuId);
        boolean save = controller.save(document);
        if (save) {
            return Response.ok().entity("true").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }
}


