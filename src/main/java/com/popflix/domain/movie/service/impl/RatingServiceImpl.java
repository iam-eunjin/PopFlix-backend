package com.popflix.domain.movie.service.impl;

import com.popflix.domain.movie.entity.Movie;
import com.popflix.domain.movie.entity.Rating;
import com.popflix.domain.movie.repository.MovieRepository;
import com.popflix.domain.movie.repository.RatingRepository;
import com.popflix.domain.movie.repository.UserRepository;
import com.popflix.domain.movie.service.RatingService;
import com.popflix.domain.user.entity.User;
import com.popflix.global.error.MovieNotFoundException;
import com.popflix.global.error.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    @Override
    public void addRating(Long userId, Long movieId, Integer score) {
        if (score < 1 || score > 5) {
            throw new IllegalArgumentException("팝콘 지수는 1점 에서 5점 사이로 가능합니다.");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException(movieId));

        Rating rating = Rating.builder()
                .user(user)
                .movie(movie)
                .rating(score)
                .build();

        ratingRepository.save(rating);
    }
}
