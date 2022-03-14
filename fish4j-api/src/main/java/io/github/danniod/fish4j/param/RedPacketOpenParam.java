package io.github.danniod.fish4j.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import io.github.danniod.fish4j.param.auth.BaseParam;

@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public @Data class RedPacketOpenParam extends BaseParam {

    @JsonProperty("oId")
    private Long oId;
}
