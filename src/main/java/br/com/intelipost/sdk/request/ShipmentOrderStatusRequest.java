package br.com.intelipost.sdk.request;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShipmentOrderStatusRequest {

    @JsonProperty("order_number")
    private String orderNumber;

    @JsonProperty("event_date")
    private OffsetDateTime eventDate = OffsetDateTime.now();

}
