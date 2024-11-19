package com.popflix.domain.photoreview;

import com.popflix.domain.common.BaseTimeEntity;
import com.popflix.domain.movie.entity.Movie;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PhotoReview extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @Column(length = 100, nullable = false)
    private String review;

    @Lob
    @Column(nullable = false)
    private byte[] reviewImage;

    @Column(nullable = false)
    private Boolean isHidden = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "photoReview")
    private List<PhotoReviewComment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "photoReview")
    private List<PhotoReviewLike> likes = new ArrayList<>();
}
