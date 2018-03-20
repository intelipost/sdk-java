package br.com.intelipost.sdk.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShipmentOrderVolumeRequest {

    private Double weight;
    private Double height;
    private Double length;
    private Double width;

    @JsonProperty("shipment_order_volume_number")
    private Integer volumeNumber;

    @JsonProperty("volume_type_code")
    private String volumeTypeCode = "box";

    @JsonProperty("products_quantity")
    private Integer quantity;

    @JsonProperty("products_nature")
    private String nature = "suplementos";

    @JsonProperty("tracking_code")
    private String trackingCode;

    @JsonProperty("shipment_order_volume_invoice")
    private ShipmentOrderVolumeInvoiceRequest invoice;

}
