package dtos;

import entities.Actor;
import entities.Movie;
import entities.Rating;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A DTO for the {@link entities.Movie} entity
 */
public class MovieDTO implements Serializable
{
    private final Integer id;
    private final String title;
    private final int year;
    private final double rating;
    private final List<ActorInnerDTO> actors = new ArrayList<>();

    public MovieDTO(Integer id, String title, int year, double rating)
    {
        this.id = id;
        this.title = title;
        this.year = year;
        this.rating = rating;
    }

    public MovieDTO(Movie movie)
    {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.year = movie.getYear();
        movie.getActors().forEach( actor -> {
            actors.add(new ActorInnerDTO(actor));
        });
        // calculate rating avg
        double ratingSum = 0.0;
        for (Rating rating: movie.getRatings())
        {
            ratingSum += rating.getRating();
        }
        this.rating = ratingSum / movie.getRatings().size();
    }

    public static List<MovieDTO> getDTOs(List<Movie> movies)
    {
        List<MovieDTO> movieDTOList = new ArrayList<>();
        movies.forEach( movie -> {
            movieDTOList.add(new MovieDTO(movie));
        });
        return movieDTOList;
    }

    public Integer getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public int getYear()
    {
        return year;
    }

    public List<ActorInnerDTO> getActors()
    {
        return actors;
    }

    @Override
    public String toString()
    {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "title = " + title + ", " +
                "year = " + year + ", " +
                "actors = " + actors + ")";
    }

    /**
     * A DTO for the {@link entities.Actor} entity
     */
    public static class ActorInnerDTO implements Serializable
    {
        private final Integer id;
        private final String name;
        private final Integer birthyear;

        public ActorInnerDTO(Integer id, String name, Integer birthyear)
        {
            this.id = id;
            this.name = name;
            this.birthyear = birthyear;
        }

        public ActorInnerDTO(Actor actor)
        {
            this.id = actor.getId();
            this.name = actor.getName();
            this.birthyear = actor.getBirthyear();
        }


        public Integer getId()
        {
            return id;
        }

        public String getName()
        {
            return name;
        }

        public Integer getBirthyear()
        {
            return birthyear;
        }

        @Override
        public String toString()
        {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ", " +
                    "name = " + name + ", " +
                    "birthyear = " + birthyear + ")";
        }
    }
}