package br.com.intelipost.sdk.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShipmentOrderCustomerResquest {

    private String email;
    private String phone;
    private String cellphone;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("federal_tax_payer_id")
    private String taxPayerId;

    @JsonProperty("shipping_address")
    private String shippingAddress;

    @JsonProperty("shipping_number")
    private String shippingNumber;

    @JsonProperty("shipping_additional")
    private String shippingAdditionalInfo;

    @JsonProperty("shipping_quarter")
    private String shippingQuarter;

    @JsonProperty("shipping_city")
    private String shippingCity;

    @JsonProperty("shipping_state")
    private String shippingState;

    @JsonProperty("shipping_zip_code")
    private String shippingZipCode;

    @JsonProperty("shipping_country")
    private String shippingCountry = "BR";

}
