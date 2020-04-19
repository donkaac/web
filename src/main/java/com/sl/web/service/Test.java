package com.sl.web.service;

import com.sl.web.constant.Secured;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by Achi on 4/19/2020.
 */
@Secured
@Path("/test")
public class Test {
    @GET
    public Response get(){
        return Response.status(200).encoding("OKKKKKKKK").build();
    }
}
