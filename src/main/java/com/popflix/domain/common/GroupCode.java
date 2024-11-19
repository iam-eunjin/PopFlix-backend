package com.popflix.domain.common;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "GroupCode")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GroupCode {
    @Id
    @Column(name = "group_code_id", length = 20)
    private String groupCodeId;

    @Column(name = "group_code_name", length = 20)
    private String groupCodeName;

    @Column(name = "group_code_desc", length = 50)
    private String groupCodeDesc;
}
