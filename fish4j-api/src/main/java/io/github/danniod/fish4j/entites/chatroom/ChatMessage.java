package io.github.danniod.fish4j.entites.chatroom;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.danniod.fish4j.entites.ChatroomMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
public @Data class ChatMessage extends ChatroomMessage {

    @JsonProperty("oId")
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
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
