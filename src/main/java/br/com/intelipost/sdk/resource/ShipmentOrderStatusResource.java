package br.com.intelipost.sdk.resource;


import com.fasterxml.jackson.databind.JsonNode;
import br.com.intelipost.sdk.request.ShipmentOrderStatusRequest;
import br.com.intelipost.sdk.response.Response;
import org.apache.http.HttpHost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ShipmentOrderStatusResource extends Resource<JsonNode, Object>{

    private static final Logger LOGGER = LoggerFactory.getLogger(ShipmentOrderStatusResource.class);

    public ShipmentOrderStatusResource(String apiKey) {
        super(apiKey);
    }

    public ShipmentOrderStatusResource(String apiKey, HttpHost httpHost) {
        super(apiKey, httpHost);
    }

    public Response setAsReadyToShip(List<ShipmentOrderStatusRequest> shipmentOrders) {
        try {
            JsonNode requestBody = objectMapper.valueToTree(shipmentOrders);

            return doPostRequest("/shipment_order/multi/ready_for_shipment/with_date", requestBody);
        } catch (Exception e) {
            LOGGER.info("Fail while setting ready to ship status for [{}]", shipmentOrders, e);
            throw new RuntimeException("Fail while updating shipment order status, details: " + e.getMessage(), e);
        }
    }

    public Response setAsShipped(List<ShipmentOrderStatusRequest> shipmentOrders) {
        try {
            JsonNode requestBody = objectMapper.valueToTree(shipmentOrders);
            return doPostRequest("/shipment_order/multi/shipped/with_date", requestBody);

        } catch (Exception e) {
            LOGGER.info("Fail while setting shipped status for [{}]", shipmentOrders, e);
            throw new RuntimeException("Fail while updating shipment order status, details: " + e.getMessage(), e);
        }
    }

    public Response setAsCanceled(ShipmentOrderStatusRequest shipmentOrder) {
        try {
            JsonNode requestBody = objectMapper.valueToTree(shipmentOrder);
            return doPostRequest("/shipment_order/cancel_shipment_order/", requestBody);

        } catch (Exception e) {
            LOGGER.info("Fail while canceling ShipmentOrder for order [{}]", shipmentOrder.getOrderNumber(), e);
            throw new RuntimeException("Fail while canceling ShipmentOrder, details: " + e.getMessage(), e);
        }
    }

}
