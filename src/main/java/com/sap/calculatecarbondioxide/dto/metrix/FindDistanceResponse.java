package com.sap.calculatecarbondioxide.dto.metrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sap.calculatecarbondioxide.dto.FindDistanceRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "distances",
    "destinations",
    "sources",
    "metadata"
})
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class FindDistanceResponse {
	
	public FindDistanceResponse() {}

    @JsonProperty("distances")
    public List<List<Double>> distances = new ArrayList<>();
    @JsonProperty("destinations")
    public List<Destination> destinations = new ArrayList<>();
    @JsonProperty("sources")
    public List<Source> sources = null;
    @JsonProperty("metadata")
    public Metadata metadata;
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
