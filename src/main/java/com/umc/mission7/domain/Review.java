package com.umc.mission7.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(nullable = false, length = 1000) String review;
    @Column(nullable = false) Integer rate;

    public void setUser(User user){
        if(this.user != null)
            user.getReviewList().remove(this);
        this.user = user;
        user.getReviewList().add(this);
    }

    public void setStore(Store store){
        if (this.rate != null)
            store.getReviewList().remove(this);
        this.store = store;
        store.getReviewList().add(this);
    }

}
