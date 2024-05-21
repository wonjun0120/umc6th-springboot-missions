package com.umc.mission7.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserConfig extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) Boolean isGetNewEvent;
    @Column(nullable = false) Boolean isGetReviewAnswer;
    @Column(nullable = false) Boolean isGetQuestionAnswer;
}
