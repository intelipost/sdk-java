package br.com.intelipost.sdk.request;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuoteRequest {

    @JsonProperty("origin_zip_code")
    private String originZipCode;
    @JsonProperty("destination_zip_code")
    private String destinationZipCode;
    @JsonProperty("quoting_mode")
    private String quotingMode;

    @JsonProperty("additional_information")
    private Map<String, Object> additionalInformation;

    private List<QuoteProductRequest> products;
}
