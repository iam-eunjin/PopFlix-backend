package com.popflix.domain.photoreview;

import com.popflix.domain.common.BaseTimeEntity;
import com.popflix.domain.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PhotoReviewComment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(length = 100, nullable = false)
    private String comment;

    @Column(nullable = false)
    private Boolean isHidden = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "review_id", nullable = false)
    private PhotoReview photoReview;

    @OneToMany(mappedBy = "comment")
    private List<PhotoReviewCommentLike> likes = new ArrayList<>();

    @OneToMany(mappedBy = "comment")
    private List<PhotoReviewReply> replies = new ArrayList<>();
}
