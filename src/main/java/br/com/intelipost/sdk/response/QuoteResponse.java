package br.com.intelipost.sdk.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteResponse {

    @JsonProperty("id")
    private Long idQuote;

    @JsonProperty("origin_zip_code")
    private String originZipCode;

    @JsonProperty("destination_zip_code")
    private String destinationZipCode;

    @JsonProperty("delivery_options")
    private List<QuoteShippingMethodResponse> quoteShippingMethods;

    private List<QuoteVolumeResponse> volumes;
}
