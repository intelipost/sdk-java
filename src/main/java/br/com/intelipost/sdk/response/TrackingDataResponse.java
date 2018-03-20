package br.com.intelipost.sdk.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackingDataResponse {

    @JsonProperty("order_number")
    private String orderNumber;

    @JsonProperty("tracking_data_array")
    private List<TrackingDataVolumeResponse> volumes;
}
