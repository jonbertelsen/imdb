package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.MovieDTO;
import facades.FacadeExample;
import facades.MovieFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("movie")
public class MovieResource
{

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final MovieFacade facade =  MovieFacade.getInstance(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllMovies()
    {
        List<MovieDTO> movieDTOList = facade.getAllMovies();
        return GSON.toJson(movieDTOList);
    }
}