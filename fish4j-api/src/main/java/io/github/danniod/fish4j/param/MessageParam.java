package io.github.danniod.fish4j.param;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import io.github.danniod.fish4j.param.auth.BaseParam;

@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public @Data class MessageParam extends BaseParam {

    private String content;

}
