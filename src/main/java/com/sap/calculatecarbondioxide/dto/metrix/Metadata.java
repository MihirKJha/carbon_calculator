package com.sap.calculatecarbondioxide.dto.metrix;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "attribution",
    "service",
    "timestamp",
    "query",
    "engine"
})
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class Metadata {
	
	public Metadata() {}

    @JsonProperty("attribution")
    public String attribution;
    @JsonProperty("service")
    public String service;
    @JsonProperty("timestamp")
    public String timestamp;
    @JsonProperty("query")
    public Query query;
    @JsonProperty("engine")
    public Engine engine;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
