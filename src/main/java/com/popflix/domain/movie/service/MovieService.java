package com.popflix.domain.movie.service;

import com.popflix.domain.movie.dto.GetMovieRatingResponseDto;

public interface MovieService {
    GetMovieRatingResponseDto getMovieRatings(Long movieId);
}
