package io.github.danniod.fish4j.entites.chatroom;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.danniod.fish4j.entites.ChatroomMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigInteger;

@EqualsAndHashCode(callSuper = true)
public @Data class RedPacketStatusMessage extends ChatroomMessage {

    @JsonProperty("oId")
    private BigInteger id;

    private Integer count;

    private Integer got;

    private String whoGive;

    private String whoGot;

}
