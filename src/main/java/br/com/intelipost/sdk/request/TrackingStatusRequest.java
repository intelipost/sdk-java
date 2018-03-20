package br.com.intelipost.sdk.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackingStatusRequest {

    @JsonProperty("order_number")
    private String orderNumber;

    @JsonProperty("sales_order_number")
    private String salesOrderNumber;

    @JsonProperty("tracking_code")
    private String trackingCode;

    private TrackingStatusHistoryRequest history;
}
