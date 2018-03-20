package br.com.intelipost.sdk.resource;

import br.com.intelipost.sdk.response.Response;
import br.com.intelipost.sdk.response.ZipCodeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZipCodeResource extends Resource<String, ZipCodeResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZipCodeResource.class);

    public ZipCodeResource(String apiKey) {
        super(apiKey);
    }

    public ZipCodeResponse getZipCodeInfo(String zipCode) {
        try {

            Response<ZipCodeResponse> response = doGetRequest("/cep_location/address_complete/" + zipCode);
            return response.getContent();

        } catch (Exception e) {
            LOGGER.info("Fail while consulting zip code [{}]", zipCode, e);
            throw new RuntimeException("Fail while consulting zipCode, details: " + e.getMessage(), e);
        }
    }

}
