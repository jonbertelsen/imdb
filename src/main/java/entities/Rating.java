package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "rating")
public class Rating
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "rating", nullable = false)
    private Integer rating;

    @NotNull
    @Column(name = "created", nullable = false)
    private Timestamp created;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Rating()
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

    public Integer getRating()
    {
        return rating;
    }

    public void setRating(Integer rating)
    {
        this.rating = rating;
    }

    public Timestamp getCreated()
    {
        return created;
    }

    public void setCreated(Timestamp created)
    {
        this.created = created;
    }

    public Movie getMovie()
    {
        return movie;
    }

    public void setMovie(Movie movie)
    {
        this.movie = movie;
    }

}