package com.popflix.domain.movie.controller;

import com.popflix.domain.movie.service.MovieApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movie")
public class MovieController {

    private final MovieApiService movieApiService;

    // 영화 정보, 장르 정보 저장
    @GetMapping("/save")
    public String saveMovies() {
        movieApiService.saveMovies();
        return "Movies saved successfully!";
    }

}
