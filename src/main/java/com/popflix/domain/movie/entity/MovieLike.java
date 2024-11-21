package com.popflix.domain.movie.entity;

import com.popflix.common.entity.BaseSoftDeleteEntity;
import com.popflix.domain.storage.entity.Storage;
import com.popflix.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MovieLike extends BaseSoftDeleteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean is_like;

    private LocalDateTime update_at;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @Builder
    public MovieLike(boolean is_like, LocalDateTime update_at, User user, Movie movie) {
        this.is_like = is_like;
        this.update_at = update_at;
        this.user = user;
        this.movie = movie;
    }
}
