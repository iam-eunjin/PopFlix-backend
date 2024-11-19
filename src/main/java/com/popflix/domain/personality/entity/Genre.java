package com.popflix.domain.personality.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Genre {
    @Id
    private Long id;

    private String name;

    @Builder
    public Genre(String name) {
        this.name = name;
    }
}
