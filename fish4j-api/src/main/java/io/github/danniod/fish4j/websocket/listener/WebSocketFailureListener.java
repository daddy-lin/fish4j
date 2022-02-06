package io.github.danniod.fish4j.websocket.listener;

import okhttp3.Response;
import okhttp3.WebSocket;

public interface WebSocketFailureListener {

    void onFailure(WebSocket webSocket, Throwable t, Response response);

}
