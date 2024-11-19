package com.popflix.domain.movie.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MovieLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean is_like;

    private LocalDateTime update_at;

    private Long user; // user entity 연결 필요

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Builder
    public MovieLike(boolean is_like, LocalDateTime update_at, Long user, Movie movie) {
        this.is_like = is_like;
        this.update_at = update_at;
        this.user = user;
        this.movie = movie;
    }
}
