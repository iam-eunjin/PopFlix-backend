package com.popflix.domain.movie.service;

public interface MovieLikeService {
    boolean likeStatus(Long userId, Long movieId);
}
