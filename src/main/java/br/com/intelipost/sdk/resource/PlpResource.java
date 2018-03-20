package br.com.intelipost.sdk.resource;

import br.com.intelipost.sdk.request.PlpRequest;
import br.com.intelipost.sdk.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlpResource extends Resource<PlpRequest, Object> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlpResource.class);

    public PlpResource(String apiKey) {
        super(apiKey);
    }

    public Response send(PlpRequest requestBody) {
        try {

            return doPostRequest("/pre_shipment_list/send_volumes", requestBody);

        } catch (Exception e) {
            LOGGER.info("Fail while sending PLP [{}]", requestBody, e);
            throw new RuntimeException("Fail while sending PLP, details: " + e.getMessage(), e);
        }
    }

}
