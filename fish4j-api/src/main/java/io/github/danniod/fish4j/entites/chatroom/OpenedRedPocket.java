package io.github.danniod.fish4j.entites.chatroom;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

public @Data class OpenedRedPocket {

    @JsonProperty("recivers")
    private List<String> receivers;

    private List<User> who;

    private RedPocketInfo info;


    public static @Data class User {

        private String userId;

        private String userName;

        private String avatar;

        private Integer userMoney;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        private Date time;
    }


    public static @Data class RedPocketInfo {

        private String msg;

        private String userName;

        @JsonProperty("userAvatarURL")
        private String userAvatarUrl;

        private Integer count;

        private Integer got;
    }
}
