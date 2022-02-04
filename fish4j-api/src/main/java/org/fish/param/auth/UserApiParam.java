package org.fish.param.auth;

import lombok.Builder;
import lombok.Data;

@Builder
public @Data class UserApiParam {

    private String nameOrEmail;

    private String userPassword;

}
