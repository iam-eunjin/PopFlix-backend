package com.popflix.domain.movie.controller;

import com.popflix.domain.movie.dto.AddRatingRequestDto;
import com.popflix.domain.movie.dto.GetMovieRatingResponseDto;
import com.popflix.domain.movie.service.MovieApiService;
import com.popflix.domain.movie.service.MovieLikeService;
import com.popflix.domain.movie.service.MovieService;
import com.popflix.domain.movie.service.RatingService;
import com.popflix.global.util.ApiUtil;
import com.popflix.global.util.ApiUtil.ApiSuccess;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieApiService movieApiService;
    private final MovieService movieService;
    private final RatingService ratingService;
    private final MovieLikeService movieLikeService;

    // 영화 정보, 장르 정보 저장
    @GetMapping("/save")
    public String saveMovies() {
        movieApiService.saveMovies();
        return "Movies saved successfully!";
    }

    // 영화 별점 추가 및 수정
    @PostMapping("/rating")
    public ApiSuccess<?> addRating(@RequestBody @Valid AddRatingRequestDto request) {
        String message = ratingService.addOrUpdateRating(request.getUserId(), request.getMovieId(), request.getRating());
        return ApiUtil.success(message);
    }

    // 영화 별점 삭제
    @DeleteMapping("/rating")
    public ApiSuccess<?> deleteRating(@RequestParam Long userId, @RequestParam Long movieId) {
        String message = ratingService.deleteRating(userId, movieId);
        return ApiUtil.success(message);
    }

    // 영화 별점 조회
    @GetMapping("/{movieId}/ratings")
    public ApiSuccess<?> getMovieRatings(@PathVariable Long movieId) {
        GetMovieRatingResponseDto movieRatingResponse  = movieService.getMovieRatings(movieId);
        return ApiUtil.success(movieRatingResponse);
    }

    // 영화 좋아요 추가 & 취소
    @PostMapping("/{movieId}/like")
    public ApiSuccess<?> likeStatus(
            @PathVariable Long movieId,
            @RequestParam Long userId
    ) {
        boolean isLiked = movieLikeService.likeStatus(userId, movieId);
        String message = isLiked ? "좋아요를 추가했습니다." : "좋아요를 취소했습니다.";
        return ApiUtil.success(message);
    }

}
