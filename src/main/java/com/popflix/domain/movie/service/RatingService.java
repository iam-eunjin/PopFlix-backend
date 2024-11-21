package com.popflix.domain.movie.service;

public interface RatingService {
    void addRating(Long userId, Long movieId, Integer score);
}
