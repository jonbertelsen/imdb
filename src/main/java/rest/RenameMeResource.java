package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.FacadeExample;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//Todo Remove or change relevant parts before ACTUAL use
@Path("xxx")
public class RenameMeResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final FacadeExample facade =  FacadeExample.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    @Path("count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }



}
