package org.fish.response.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

public @Data class Result<T> {

    private Integer code;

    private String msg;

    @JsonProperty("Key")
    private String key;

    private T data;

    public static final int SUCCESS = 0;

    public boolean isSuccess() {
        return code != null && this.code == SUCCESS;
    }

}

