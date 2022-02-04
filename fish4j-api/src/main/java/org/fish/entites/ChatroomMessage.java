package org.fish.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

public @Data class ChatroomMessage {

    @JsonProperty("oId")
    private BigInteger id;

    private Date time;

    private String userName;

    private String userNickname;

    @JsonProperty("userAvatarURL")
    private String userAvatarUrl;

    private String sysMetal;

    private String content;

    @JsonProperty("md")
    private String markdownContent;

}
