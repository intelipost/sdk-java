package br.com.intelipost.sdk.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ZipCodeResponse{
    private String state;
    private String city;
    private String street;

    @JsonProperty("bairro")
    private String neighborhood;

    @JsonProperty("state_short")
    private String stateAbreviation;

    @JsonProperty("additional_info")
    private String additionalInfo;
}
