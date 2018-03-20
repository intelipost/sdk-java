package br.com.intelipost.sdk.response;

import java.time.ZonedDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShipmentOrderResponse {

    @JsonProperty("id")
    private Long idShipmentOrder;

    @JsonProperty("customer_shipping_costs")
    private Double shippingCost;

    @JsonProperty("shipped_date_iso")
    private ZonedDateTime shippedDate;

    @JsonProperty("order_number")
    private String orderNumber;

    @JsonProperty("sales_order_number")
    private String salesOrderNumber;

    @JsonProperty("delivery_method_id")
    private Integer idDeliveryMethod;

    @JsonProperty("created_iso")
    private ZonedDateTime created;

    @JsonProperty("estimated_delivery_date")
    private ZonedDateTime estimatedDeliveryDate;

    @JsonProperty("shipment_order_volume_array")
    private List<ShipmentOrderVolumeResponse> orderVolumes;
}
