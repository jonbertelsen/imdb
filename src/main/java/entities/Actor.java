package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "actor")
public class Actor
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 45)
    @NotNull
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "birthyear")
    private Integer birthyear;

    @ManyToMany
    @JoinTable(name = "link_movie_actor",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private Set<Movie> movies = new LinkedHashSet<>();

    public Actor()
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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getBirthyear()
    {
        return birthyear;
    }

    public void setBirthyear(Integer birthyear)
    {
        this.birthyear = birthyear;
    }

    public Set<Movie> getMovies()
    {
        return movies;
    }

    public void setMovies(Set<Movie> movies)
    {
        this.movies = movies;
    }

}