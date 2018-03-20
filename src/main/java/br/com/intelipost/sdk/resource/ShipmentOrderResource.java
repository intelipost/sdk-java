package br.com.intelipost.sdk.resource;

import br.com.intelipost.sdk.client.IntelipostClient;
import br.com.intelipost.sdk.request.ShipmentOrderRequest;
import br.com.intelipost.sdk.response.Response;
import br.com.intelipost.sdk.response.ShipmentOrderResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShipmentOrderResource extends Resource<ShipmentOrderRequest, ShipmentOrderResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(IntelipostClient.class);


    public ShipmentOrderResource(String apiKey) {
        super(apiKey);
    }

    public ShipmentOrderResponse getShipmentOrder(String orderNumber) {
        try {

            Response<ShipmentOrderResponse> response = super.doGetRequest("/shipment_order/" + orderNumber);
            return response.getContent();

        } catch (Exception e) {
            LOGGER.info("Fail while retrieving shipment order from number [{}]", orderNumber, e);
            throw new RuntimeException("Fail while retrieving shipment order, details: " + e.getMessage(), e);
        }
    }

    public ShipmentOrderResponse doShipmentOrder(ShipmentOrderRequest requestBody) {
        try {

            Response<ShipmentOrderResponse> response = super.doPostRequest("/shipment_order", requestBody);
            return response.getContent();

        } catch (Exception e) {
            LOGGER.info("Fail while creating ShipmentOrder for order [{}]", requestBody.getOrderNumber(), e);
            throw new RuntimeException("Fail while creating ShipmentOrder, details: " + e.getMessage(), e);
        }
    }

}
