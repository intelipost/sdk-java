package br.com.intelipost.sdk.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuoteProductRequest {

    private Double weight;
    private Double width;
    private Double height;
    private Double length;
    private Integer quantity;
    private String description;


    @JsonProperty("sku_id")
    private String idSku;

    @JsonProperty("can_group")
    private boolean group = true;

    @JsonProperty("cost_of_goods")
    private Double unitPrice;


}

