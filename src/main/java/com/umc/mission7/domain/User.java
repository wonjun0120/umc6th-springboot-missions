package com.umc.mission7.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

    @Column(nullable = false, length = 50) private String email;
    @Column(nullable = false, length = 20) private String name;
    @Column(nullable = false, length = 20) private String nickName;
    @Column(nullable = false) private String birth;
    @Column(nullable = false, length = 40) private String address;
    @Column(nullable = false) private Boolean isAgreeLocation;
    @Column(nullable = false) private Boolean isAgreeMarketing;
    @Column(nullable = false) @ColumnDefault("0") private Long point;

    @Column(columnDefinition = "VARCHAR(10)")
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @OneToOne
    @JoinColumn(name = "user_config_id")
    private UserConfig userConfig;

    @OneToMany
    @JoinColumn(name = "user_food_category_id")
    private List<UserFoodCategory> userFoodCategories = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMission> missionList = new ArrayList<>();
}