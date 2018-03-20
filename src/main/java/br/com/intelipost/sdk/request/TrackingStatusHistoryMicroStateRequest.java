package br.com.intelipost.sdk.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackingStatusHistoryMicroStateRequest {

    private Long id;
    private Long code;
    private String name;
    private String description;

    @JsonProperty("shipment_volume_state")
    private String shipmentState;
}
