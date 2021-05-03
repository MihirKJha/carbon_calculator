
package com.sap.calculatecarbondioxide.dto.search;

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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "text",
    "size",
    "layers",
    "private",
    "boundary.country",
    "lang",
    "querySize",
    "parser",
    "parsed_text"
})
public class Query {

    @JsonProperty("text")
    public String text;
    @JsonProperty("size")
    public int size;
    @JsonProperty("layers")
    public List<String> layers = new ArrayList<String>();
    @JsonProperty("private")
    public boolean _private;
    @JsonProperty("boundary.country")
    public List<String> boundaryCountry = new ArrayList<String>();
    @JsonProperty("lang")
    public Lang lang;
    @JsonProperty("querySize")
    public int querySize;
    @JsonProperty("parser")
    public String parser;
    @JsonProperty("parsed_text")
    public ParsedText parsedText;
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
