package io.github.danniod.fish4j.entites.chatroom;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.danniod.fish4j.entites.ChatroomMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
public @Data class RedPacketMessage extends ChatroomMessage {

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

    private RedPacket redPacket;

    @SneakyThrows
    public void setContent(String content) {
        this.content = content;
        this.redPacket = new ObjectMapper().readValue(content, RedPacket.class);
    }

    public static @Data class RedPacket {

        private String msg;

        @JsonProperty("recivers")
        private String receivers;

        private String senderId;

        private String msgType;

        private Integer money;

        private Integer count;

        private String type;

        private Integer got;

        private List<String> who;
    }

}
