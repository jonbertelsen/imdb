package entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "movie")
public class Movie
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 45)
    @Column(name = "title", length = 45)
    private String title;

    @Size(max = 45)
    @Column(name = "year", length = 45)
    private int year;

    @OneToMany(mappedBy = "movie")
    private Set<Rating> ratings = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "link_movie_actor",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private Set<Actor> actors = new LinkedHashSet<>();

    public Movie()
    {
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public Set<Rating> getRatings()
    {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings)
    {
        this.ratings = ratings;
    }

    public Set<Actor> getActors()
    {
        return actors;
    }

    public void setActors(Set<Actor> actors)
    {
        this.actors = actors;
    }

}