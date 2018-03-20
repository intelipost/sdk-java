package br.com.intelipost.sdk.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteVolumeResponse {

    private Double weight;
    private Double width;
    private Double height;
    private Double length;
    private String description;

    @JsonProperty("cost_of_goods")
    private Double costOfGoods;

    @JsonProperty("volume_type")
    private String volumeType;

    @JsonProperty("product_category")
    private String productCategory;
}
