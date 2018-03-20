package br.com.intelipost.sdk.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlpRequest {

    @JsonProperty("logistic_provider_id")
    private Integer logisticProvider;

    @JsonProperty("shipment_order_volume_ids")
    private List<Long> shipmentOrderVolumesId;

}
