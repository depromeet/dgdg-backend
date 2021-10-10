package com.depromeet.dgdg.domain.domain.user;

import com.depromeet.dgdg.domain.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String socialId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SocialProvider socialProvider;

    @Column(nullable = false)
    private String name;

    private String profileUrl;

    private String refreshToken;

    @Builder(access = AccessLevel.PRIVATE)
    private User(String socialId, SocialProvider socialProvider, String name, String profileUrl) {
        this.socialId = socialId;
        this.socialProvider = socialProvider;
        this.name = name;
        this.profileUrl = profileUrl;
    }

    public static User newKaKaoInstance(String socialId, String name, String profileUrl) {
        return User.builder()
            .socialId(socialId)
            .socialProvider(SocialProvider.KAKAO)
            .name(name)
            .profileUrl(profileUrl)
            .build();
    }

}
