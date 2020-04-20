package com.sl.web.service;

import com.sl.web.model.RestAuthentication;
import com.sl.web.model.User;
import com.sl.web.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Achi on 4/20/2020.
 */
@Path("/auth")
public class AuthenticationEndpoint {
    @POST
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public Response authenticateUser(@FormParam("email") String email,
                                     @FormParam("password") String password) {

        try {

            // Authenticate the user using the credentials provided
            String token = authenticate(email, password);

            // Issue a token for the user
           // String token = issueToken(email);

            // Return the token on the response
            return Response.ok(token).build();

        } catch (Exception e) {

            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    private String authenticate(String email, String password) throws Exception {
        // Authenticate against a database, LDAP, file or whatever
        // Throw an Exception if the credentials are invalid

        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = session.createQuery("FROM User WHERE email=:uname and password=:pass", User.class).setParameter("uname", email).setParameter("pass", password).uniqueResult();
        if (user != null){
            List<RestAuthentication> authentications = session.createQuery("FROM RestAuthentication WHERE userByUserId=:user ORDER BY date desc", RestAuthentication.class).setParameter("user", user).list();
            RestAuthentication authentication = authentications.get(0);
            return authentication.getToken();
        }else{
           throw new Exception("credentials are invalid");
        }

    }

    private String issueToken(String email) {
        // Issue a token (can be a random String persisted to a database or a JWT token)
        // The issued token must be associated to a user
        // Return the issued token
        return null;
    }
}
