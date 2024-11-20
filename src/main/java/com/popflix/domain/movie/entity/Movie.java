package com.popflix.domain.movie.entity;

import com.popflix.domain.storage.entity.MovieStorage;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String movieName;

    @Column(length = 1000)
    private String plot;

    private String posterPath;

    private LocalDate releaseDate;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
    private List<MovieActor> movieActors = new ArrayList<>();

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
    private List<MovieStorage> movieStorages = new ArrayList<>();

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
    private List<MovieLike> movieLikes = new ArrayList<>();

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
    private List<MovieGenre> movieGenres = new ArrayList<>();

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
    private List<Rating> ratings = new ArrayList<>();

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
    private List<Recommendation> recommendations = new ArrayList<>();

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
    private List<ReviewVideo> reviewVideos = new ArrayList<>();

    @Builder
    public Movie(String movieName, String plot, String posterPath, LocalDate releaseDate, List<MovieActor> movieActors, List<MovieStorage> movieStorages, List<MovieLike> movieLikes, List<MovieGenre> movieGenres, List<Rating> ratings, List<Recommendation> recommendations, List<ReviewVideo> reviewVideos) {
        this.movieName = movieName;
        this.plot = plot;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.movieActors = movieActors;
        this.movieStorages = movieStorages;
        this.movieLikes = movieLikes;
        this.movieGenres = movieGenres;
        this.ratings = ratings;
        this.recommendations = recommendations;
        this.reviewVideos = reviewVideos;
    }
}
