package br.com.intelipost.sdk.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShippingMethodResponse {

    private String name;

    @JsonProperty("service_code")
    private Integer serviceCode;

    @JsonProperty("logistics_provider_name")
    private String logisticsProviderName;

    @JsonProperty("logistics_provider_tax_id")
    private String logisticsProviderTaxId;

    @JsonProperty("logistics_provider_code")
    private String logisticsProviderCode;

}
