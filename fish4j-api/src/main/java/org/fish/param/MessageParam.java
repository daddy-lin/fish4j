package org.fish.param;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.fish.param.auth.BaseParam;

@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public @Data class MessageParam extends BaseParam {

    private String content;

}
