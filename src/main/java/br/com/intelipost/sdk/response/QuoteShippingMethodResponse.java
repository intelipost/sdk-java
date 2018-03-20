package br.com.intelipost.sdk.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteShippingMethodResponse {

    @JsonProperty("delivery_method_id")
    private Integer idDeliveryMethod;

    @JsonProperty("description")
    private String name;

    @JsonProperty("delivery_estimate_business_days")
    private Integer deliveryEstimateDays;

    @JsonProperty("provider_shipping_cost")
    private Double providerShippingCost;

    @JsonProperty("final_shipping_cost")
    private Double shippingCost;

    @JsonProperty("delivery_note")
    private String deliveryNote;

    @JsonProperty("delivery_method_type")
    private String deliveryMethodType;

    @JsonProperty("delivery_method_name")
    private String deliveryMethodName;


}
