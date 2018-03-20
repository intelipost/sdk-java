package br.com.intelipost.sdk.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackingDataVolumeResponse {
    @JsonProperty("shipment_order_volume_number")
    private Integer orderVolumeNumber;

    @JsonProperty("tracking_data")
    private String trackingData;

    @JsonProperty("tracking_code")
    private String trackingCode;
}
