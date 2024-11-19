package com.popflix.domain.movie.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String movieName;

    private String plot;

    private String posterPath;

    private LocalDateTime releaseDate;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MovieActor> movieActors = new ArrayList<>();

    @Builder
    public Movie(String movieName, String plot, String posterPath, LocalDateTime releaseDate, List<MovieActor> movieActors){
        this.movieName = movieName;
        this.plot = plot;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.movieActors = movieActors;
    }
}
