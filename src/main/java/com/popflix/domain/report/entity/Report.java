package com.popflix.domain.report.entity;

import com.popflix.common.entity.BaseSoftDeleteEntity;
import com.popflix.common.entity.BaseTimeEntity;
import com.popflix.domain.report.enums.ReportTarget;
import com.popflix.domain.report.enums.ReportStatus;
import com.popflix.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Report")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Report extends BaseSoftDeleteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reporter_id", nullable = false)
    private User reporter;

    @Enumerated(EnumType.STRING)
    @Column(name = "target_type", nullable = false)
    private ReportTarget targetType;

    @Column(name = "target_id", nullable = false)
    private Long targetId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ReportStatus status = ReportStatus.PENDING;

    @Builder
    public Report(User reporter, ReportTarget targetType, Long targetId) {
        this.reporter = reporter;
        this.targetType = targetType;
        this.targetId = targetId;
    }
}