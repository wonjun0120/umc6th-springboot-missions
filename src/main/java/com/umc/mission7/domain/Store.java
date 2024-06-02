package com.umc.mission7.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    @Column(nullable = false) String location;
    @Column(nullable = false) String address;
    @Column(nullable = false) String name;
    @Column(nullable = false) String phoneNumber;
    @Column(nullable = false) LocalTime openTime;
    @Column(nullable = false) LocalTime closeTime;
    @Column(nullable = false) Long point;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Mission> missionList = new ArrayList<>();
}
