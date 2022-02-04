package org.fish.client;

import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.fish.websocket.listener.WebSocketCloseListener;
import org.fish.websocket.listener.WebSocketFailureListener;
import org.fish.websocket.listener.WebSocketMessageListener;
import org.fish.websocket.listener.WebSocketOpenListener;

public class WebSocketClient extends WebSocketListener {

    private final WebSocketOpenListener openListener;

    private final WebSocketMessageListener messageListener;

    private final WebSocketCloseListener closeListener;

    private final WebSocketFailureListener failureListener;


    public WebSocketClient(WebSocketOpenListener openListener, WebSocketCloseListener closeListener, WebSocketFailureListener failureListener, WebSocketMessageListener messageListener) {
        this.openListener = openListener;
        this.closeListener = closeListener;
        this.failureListener = failureListener;
        this.messageListener = messageListener;
    }


    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        openListener.onOpen(webSocket, response);
    }


    @Override
    public void onMessage(WebSocket webSocket, String text) {
        messageListener.onMessage(webSocket, text);
    }


    @Override
    public void onClosing(WebSocket webSocket, int code, String reason) {
        closeListener.onClose(webSocket, code, reason);
    }


    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        failureListener.onFailure(webSocket, t, response);
    }


}
