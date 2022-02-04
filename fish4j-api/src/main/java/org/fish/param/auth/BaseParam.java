package org.fish.param.auth;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public @Data class BaseParam {

    private String apiKey;
}
