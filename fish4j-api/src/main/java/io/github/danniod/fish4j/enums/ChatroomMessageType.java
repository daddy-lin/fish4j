package io.github.danniod.fish4j.enums;

import io.github.danniod.fish4j.entites.ChatroomMessage;
import io.github.danniod.fish4j.entites.chatroom.*;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum ChatroomMessageType {

    MSG("msg", ChatMessage.class),
    ONLINE("online", OnlineMessage.class),
    RED_PACKET("redPacket", RedPacketMessage.class),
    RED_PACKET_STATUS("redPacketStatus", RedPacketStatusMessage.class),
    REVOKE("revoke", RevokeMessage.class),
    UNKNOWN("default", ChatroomMessage.class);


    @Getter
    private String type;
    @Getter
    private Class<? extends ChatroomMessage> typeClass;

    private static final Map<String, ChatroomMessageType> MAPPER;


    static {
        MAPPER = Arrays.stream(values()).collect(Collectors.toMap(ChatroomMessageType::getType, messageType -> messageType));
    }


    ChatroomMessageType(String type, Class<? extends ChatroomMessage> typeClass) {
        this.type = type;
        this.typeClass = typeClass;
    }


    public static ChatroomMessageType fromType(String type) {
        return MAPPER.get(type) != null ? MAPPER.get(type) : UNKNOWN;
    }

}
