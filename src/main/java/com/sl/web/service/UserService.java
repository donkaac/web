package com.sl.web.service;

import com.sl.web.constant.Secured;
import com.sl.web.util.DataController;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import com.sl.web.model.*;


@Secured
@Path("/user")
public class UserService {
    DataController controller = new DataController();

    @GET
    @Produces("application/json")
    public Response getAll() {
        List<User> all = controller.getAll(User.class);
        return Response.status(200).entity(all).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCityById(@PathParam("id") Integer id) {
        User user = controller.getById(User.class, id);
        return Response.status(200).entity(user).build();
    }


}
