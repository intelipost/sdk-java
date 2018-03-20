package br.com.intelipost.sdk.request;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShipmentOrderVolumeInvoiceRequest {

    @JsonProperty("invoice_series")
    private Integer series;

    @JsonProperty("invoice_number")
    private Long number;

    @JsonProperty("invoice_key")
    private String key;

    @JsonProperty("invoice_date")
    private ZonedDateTime date;

    @JsonProperty("invoice_total_value")
    private Double totalValue;

    @JsonProperty("invoice_products_value")
    private Double productValue;

    @JsonProperty("invoice_cfop")
    private String cfop;
}

