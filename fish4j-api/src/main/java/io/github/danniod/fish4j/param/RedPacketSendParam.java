package io.github.danniod.fish4j.param;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.List;

@Builder
public @Data class RedPacketSendParam {

    @JsonIgnore
    private String apiKey;

    private String msg;

    private Integer money;

    private Integer count;

    @JsonProperty("recivers")
    private List<String> receivers;

    private String type;

    @Override
    @SneakyThrows
    public String toString() {
        return String.format("[redpacket]%s[/redpacket]", new ObjectMapper().writeValueAsString(this));
    }
}
