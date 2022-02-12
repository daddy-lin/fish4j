package io.github.danniod.fish4j.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

public @Data class Storage {

    private List<String> errFiles;

    @JsonProperty("succMap")
    private Map<String, String> successMap;

}
