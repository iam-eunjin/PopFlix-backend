package com.popflix.domain.movie.entity;

import com.popflix.domain.personality.entity.Genre;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
public class MovieGenre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genre;


    @Builder
    public MovieGenre(Movie movie, Genre genre){
        this.movie = movie;
        this.genre = genre;
    }
}
