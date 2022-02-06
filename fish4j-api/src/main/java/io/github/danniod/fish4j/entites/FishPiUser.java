package io.github.danniod.fish4j.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


public @Data class FishPiUser {

    @JsonProperty("oId")
    private String oid;

    private String userNo;

    private String userName;

    private String userRole;

    private String userNickname;

    @JsonProperty("userAvatarURL")
    private String userAvatarUrl;

    private String userCity;

    private Boolean userOnlineFlag;

    private Long onlineMinute;

    private Long userPoint;

    private String canFollow;

    private String userAppRole;

    private String userIntro;

    @JsonProperty("userURL")
    private String userUrl;

    private String cardBg;

    private Integer followerCount;

    private Integer followingUserCount;

    private String sysMetal;

}