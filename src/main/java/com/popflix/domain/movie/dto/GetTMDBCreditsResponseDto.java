package com.popflix.domain.movie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetTMDBCreditsResponseDto {
    private List<CastMemberDto> cast;    // 출연진 목록
    private List<CrewMemberDto> crew;    // 감독 목록

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CastMemberDto {
        private String name;
        private String character;
        private Integer gender;
        private String creditId;

        @Override
        public String toString() {
            return "CastMemberDto{" +
                    "name='" + name + '\'' +
                    ", character='" + character + '\'' +
                    ", gender=" + gender +
                    ", creditId='" + creditId + '\'' +
                    '}';
        }
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CrewMemberDto {
        private String department;
        private String job;
        private String name;
        private Integer gender;
        private String creditId;

        @Override
        public String toString() {
            return "CrewMemberDto{" +
                    "department='" + department + '\'' +
                    ", job='" + job + '\'' +
                    ", name='" + name + '\'' +
                    ", gender=" + gender +
                    ", creditId='" + creditId + '\'' +
                    '}';
        }
    }
}
