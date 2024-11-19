package com.popflix.domain.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "User_Genre")
@Getter
public class UserGenre {
    @Id
    @Column(name = "genre_id")
    private Long genreId;

    @Column(name = "user_id")
    private Long userId;
}
