package br.com.intelipost.sdk.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackingCodeResponse {

    @JsonProperty("tracking_codes")
    private List<String> trackingCodes;

    @JsonProperty("available_tracking_codes")
    private Long avaliableTrackingCodes;
}
