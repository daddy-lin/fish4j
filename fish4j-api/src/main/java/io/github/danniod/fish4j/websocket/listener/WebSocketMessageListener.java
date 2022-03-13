package io.github.danniod.fish4j.websocket.listener;

import io.github.danniod.fish4j.entites.ChatroomMessage;
import okhttp3.WebSocket;

public interface WebSocketMessageListener {

    void onMessage(WebSocket webSocket, ChatroomMessage message);

}
