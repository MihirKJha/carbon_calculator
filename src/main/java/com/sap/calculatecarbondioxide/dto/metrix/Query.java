package com.sap.calculatecarbondioxide.dto.metrix;

import java.util.HashMap;
import java.util.List;
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
    "locations",
    "profile",
    "responseType",
    "metricsStrings",
    "metrics",
    "units"
})
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class Query {
	
	public Query() {}

    @JsonProperty("locations")
    public List<List<Float>> locations = null;
    @JsonProperty("profile")
    public String profile;
    @JsonProperty("responseType")
    public String responseType;
    @JsonProperty("metricsStrings")
    public List<String> metricsStrings = null;
    @JsonProperty("metrics")
    public List<String> metrics = null;
    @JsonProperty("units")
    public String units;
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
