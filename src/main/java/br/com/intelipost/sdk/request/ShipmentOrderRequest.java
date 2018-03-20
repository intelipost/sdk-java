package br.com.intelipost.sdk.request;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShipmentOrderRequest {

    @JsonProperty("quote_id")
    private Long idQuote;

    @JsonProperty("customer_shipping_costs")
    private Double shippingCost;

    @JsonProperty("shipped_date")
    private OffsetDateTime shippedDate;

    @JsonProperty("sales_order_number")
    private Long salesOrderNumber;

    @JsonProperty("order_number")
    private String orderNumber;

    @JsonProperty("delivery_method_id")
    private Integer idDeliveryMethod;

    @JsonProperty("created")
    private OffsetDateTime created;

    @JsonProperty("estimated_delivery_date")
    private LocalDateTime estimatedDeliveryDate;

    @JsonProperty("origin_warehouse_code")
    private String warehouseCode;

    @JsonProperty("end_customer")
    private ShipmentOrderCustomerResquest customer;

    @JsonProperty("shipment_order_volume_array")
    private List<ShipmentOrderVolumeRequest> orderVolumes;

}
