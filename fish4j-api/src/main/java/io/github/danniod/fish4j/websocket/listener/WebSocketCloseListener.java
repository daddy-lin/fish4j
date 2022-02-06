package io.github.danniod.fish4j.websocket.listener;

import okhttp3.WebSocket;

public interface WebSocketCloseListener {

    void onClose(WebSocket webSocket, int code, String reason);

}
