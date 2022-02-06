package io.github.danniod.fish4j.param.auth;

import lombok.Builder;
import lombok.Data;

@Builder
public @Data class UserApiParam {

    private String nameOrEmail;

    private String userPassword;

}
