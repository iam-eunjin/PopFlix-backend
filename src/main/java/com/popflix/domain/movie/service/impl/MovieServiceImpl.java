package com.popflix.domain.movie.service.impl;

import com.popflix.domain.movie.dto.GetMovieRatingResponseDto;
import com.popflix.domain.movie.dto.GetRatingResponseDto;
import com.popflix.domain.movie.entity.Movie;
import com.popflix.domain.movie.entity.Rating;
import com.popflix.domain.movie.repository.MovieRepository;
import com.popflix.domain.movie.repository.RatingRepository;
import com.popflix.domain.movie.service.MovieService;
import com.popflix.domain.movie.exception.MovieNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final RatingRepository ratingRepository;

    // 별점 조회 및 평균 별점 계산
    @Override
    public GetMovieRatingResponseDto getMovieRatings(Long movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException(movieId));

        // 영화의 평점 평균 계산
        Double averageRating = ratingRepository.findAverageRatingByMovieId(movieId);

        Double roundedRating = averageRating != null ? averageRating : 0.0;

        List<Rating> ratings = ratingRepository.findAllRatingsByMovieId(movieId);

        return GetMovieRatingResponseDto.builder()
                .movieId(movie.getId())
                .title(movie.getTitle())
                .averageRating(roundedRating)
                .ratings(ratings.stream()
                        .map(r -> GetRatingResponseDto.builder()
                                .userId(r.getUser().getUserId())
                                .rating(r.getRating())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
