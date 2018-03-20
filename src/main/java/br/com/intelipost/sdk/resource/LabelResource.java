package br.com.intelipost.sdk.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.intelipost.sdk.response.LabelResponse;
import br.com.intelipost.sdk.response.Response;

public class LabelResource extends Resource<String, LabelResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LabelResource.class);

    public LabelResource(String apiKey) {
        super(apiKey);
    }

    public LabelResponse getLabel(String orderNumber, Integer shipmentOrderVolumeNumber) {
        try {

            Response<LabelResponse> response = doGetRequest("/shipment_order/get_label/" + orderNumber + "/" + shipmentOrderVolumeNumber);
            return response.getContent();
        } catch (Exception e) {
            LOGGER.info("Fail while retrieving label for shipment order [{}]", orderNumber, e);
            throw new RuntimeException("Fail while retrieving label, details: " + e.getMessage(), e);
        }
    }

}
