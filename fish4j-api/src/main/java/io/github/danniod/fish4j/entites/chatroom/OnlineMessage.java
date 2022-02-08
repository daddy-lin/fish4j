package io.github.danniod.fish4j.entites.chatroom;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.danniod.fish4j.entites.ChatroomMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
public @Data class OnlineMessage extends ChatroomMessage {

    private Integer onlineChatCnt;
    private List<OnlineUser> users;


    public static @Data class OnlineUser {

        @JsonProperty("userAvatarURL")
        private String userAvatarUrl;

        private String userName;

        private String homePage;
    }
}
