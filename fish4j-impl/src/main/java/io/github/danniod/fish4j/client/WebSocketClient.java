package io.github.danniod.fish4j.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.danniod.fish4j.entites.ChatroomMessage;
import io.github.danniod.fish4j.enums.ChatroomMessageType;
import io.github.danniod.fish4j.websocket.listener.WebSocketCloseListener;
import io.github.danniod.fish4j.websocket.listener.WebSocketFailureListener;
import io.github.danniod.fish4j.websocket.listener.WebSocketMessageListener;
import io.github.danniod.fish4j.websocket.listener.WebSocketOpenListener;
import lombok.SneakyThrows;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class WebSocketClient extends WebSocketListener {

    private final WebSocketOpenListener openListener;

    private final WebSocketMessageListener messageListener;

    private final WebSocketCloseListener closeListener;

    private final WebSocketFailureListener failureListener;

    private static final ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

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
    @SneakyThrows
    public void onMessage(WebSocket webSocket, String text) {
        final JsonNode jsonNode = OBJECT_MAPPER.readTree(text);
        String type = jsonNode.get("type").asText();
        if (type.equals("msg")) {
            if (jsonNode.get("md") == null && jsonNode.get("content").asText().startsWith("{")) {
                text = text.replace("\"type\":\"msg\"", "\"type\":\"redPacket\"");
                type = "redPacket";
            }
        }
        final ChatroomMessage message = OBJECT_MAPPER.readValue(text, ChatroomMessageType.fromType(type).getTypeClass());
        messageListener.onMessage(webSocket, message);
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
