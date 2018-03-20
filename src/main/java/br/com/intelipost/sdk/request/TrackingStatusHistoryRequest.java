package br.com.intelipost.sdk.request;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackingStatusHistoryRequest {

    @JsonProperty("shipment_order_volume_state_history")
    private Long stateHistoryId;

    @JsonProperty("shipment_order_volume_id")
    private Long shipmentOrderVolumeId;

    @JsonProperty("shipment_order_volume_state")
    private String shipmentOrderVolumeState;

    @JsonProperty("tracking_state")
    private String trackingState;

    @JsonProperty("provider_message")
    private String providerMessage;

    @JsonProperty("provider_state")
    private String providerState;

    @JsonProperty("esprinter_message")
    private String esprinterMessage;

    @JsonProperty("created_iso")
    private ZonedDateTime created;

    @JsonProperty("shipment_volume_micro_state")
    private TrackingStatusHistoryMicroStateRequest microState;
}
