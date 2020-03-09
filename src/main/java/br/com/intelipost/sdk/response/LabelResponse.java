package br.com.intelipost.sdk.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LabelResponse {

    @JsonProperty("order_number")
    private String orderNumber;

    @JsonProperty("shipment_order_volume_number")
    private Long shipmentOrderVolumeNumber;

    @JsonProperty("label_url")
    private String labelUrl;

}
