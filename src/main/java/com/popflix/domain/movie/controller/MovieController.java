package com.popflix.domain.movie.controller;

import com.popflix.domain.movie.dto.AddRatingRequestDto;
import com.popflix.domain.movie.dto.GetMovieRatingResponseDto;
import com.popflix.domain.movie.service.MovieApiService;
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

    // 영화 정보, 장르 정보 저장
    @GetMapping("/save")
    public String saveMovies() {
        movieApiService.saveMovies();
        return "Movies saved successfully!";
    }

    // 영화 별점 추가
    @PostMapping("/rating")
    public ApiSuccess<?> addRating(@RequestBody @Valid AddRatingRequestDto request) {
        ratingService.addRating(request.getUserId(), request.getMovieId(), request.getRating());
        return ApiUtil.success("팝콘이 정상적으로 처리되었습니다.");
    }

    // 영화 별점 조회
    @GetMapping("/{movieId}/ratings")
    public ApiSuccess<?> getMovieRatings(@PathVariable Long movieId) {
        GetMovieRatingResponseDto response = movieService.getMovieRatings(movieId);
        return ApiUtil.success(response);
    }

}
