
package com.sap.calculatecarbondioxide.dto.search;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "gid",
    "layer",
    "source",
    "source_id",
    "name",
    "confidence",
    "match_type",
    "accuracy",
    "country",
    "country_gid",
    "country_a",
    "region",
    "region_gid",
    "region_a",
    "locality",
    "locality_gid",
    "continent",
    "continent_gid",
    "label",
    "localadmin",
    "localadmin_gid",
    "county",
    "county_gid",
    "county_a"
})
public class Properties {

    @JsonProperty("id")
    public String id;
    @JsonProperty("gid")
    public String gid;
    @JsonProperty("layer")
    public String layer;
    @JsonProperty("source")
    public String source;
    @JsonProperty("source_id")
    public String sourceId;
    @JsonProperty("name")
    public String name;
    @JsonProperty("confidence")
    public int confidence;
    @JsonProperty("match_type")
    public String matchType;
    @JsonProperty("accuracy")
    public String accuracy;
    @JsonProperty("country")
    public String country;
    @JsonProperty("country_gid")
    public String countryGid;
    @JsonProperty("country_a")
    public String countryA;
    @JsonProperty("region")
    public String region;
    @JsonProperty("region_gid")
    public String regionGid;
    @JsonProperty("region_a")
    public String regionA;
    @JsonProperty("locality")
    public String locality;
    @JsonProperty("locality_gid")
    public String localityGid;
    @JsonProperty("continent")
    public String continent;
    @JsonProperty("continent_gid")
    public String continentGid;
    @JsonProperty("label")
    public String label;
    @JsonProperty("localadmin")
    public String localadmin;
    @JsonProperty("localadmin_gid")
    public String localadminGid;
    @JsonProperty("county")
    public String county;
    @JsonProperty("county_gid")
    public String countyGid;
    @JsonProperty("county_a")
    public String countyA;
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
