package org.fish.websocket.listener;

import okhttp3.Response;
import okhttp3.WebSocket;

public interface WebSocketOpenListener {

    void onOpen(WebSocket webSocket, Response response);

}
