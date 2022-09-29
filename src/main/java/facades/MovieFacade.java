package facades;

import dtos.MovieDTO;
import entities.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class MovieFacade
{
    private static MovieFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private MovieFacade() {}

    public static MovieFacade getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MovieFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }


    public List<MovieDTO> getAllMovies()
    {
        EntityManager em = getEntityManager();
        try
        {
            TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m", Movie.class);
            List<Movie> movies = query.getResultList();
            return MovieDTO.getDTOs(movies);


        } finally
        {
            em.close();
        }


    }
}
