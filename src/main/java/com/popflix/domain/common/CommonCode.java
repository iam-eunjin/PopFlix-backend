package com.popflix.domain.common;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.*;

@Entity
@Table(name = "CommonCode")
@Getter
@NoArgsConstructor(access = PROTECTED)
public class CommonCode {
    @Id
    @Column(name = "common_code_id", length = 20)
    private String commonCodeId;

    @Column(name = "group_code_id", length = 20)
    private String groupCodeId;

    @Column(name = "common_code_name", length = 50)
    private String commonCodeName;
}
