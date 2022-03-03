package io.github.danniod.fish4j.entites.chatroom;

import io.github.danniod.fish4j.entites.ChatroomMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
public @Data class DiscussChangedMessage extends ChatroomMessage {

    private String whoChanged;

    private String newDiscuss;

}
