package br.com.intelipost.sdk.client;

import br.com.intelipost.sdk.request.PlpRequest;
import br.com.intelipost.sdk.request.QuoteRequest;
import br.com.intelipost.sdk.request.ShipmentOrderRequest;
import br.com.intelipost.sdk.request.ShipmentOrderStatusRequest;
import br.com.intelipost.sdk.request.TrackingCodeRequest;
import br.com.intelipost.sdk.request.TrackingDataRequest;
import br.com.intelipost.sdk.resource.LabelResource;
import br.com.intelipost.sdk.resource.PlpResource;
import br.com.intelipost.sdk.resource.QuoteResource;
import br.com.intelipost.sdk.resource.ShipmentOrderResource;
import br.com.intelipost.sdk.resource.ShipmentOrderStatusResource;
import br.com.intelipost.sdk.resource.TrackingCodeResource;
import br.com.intelipost.sdk.resource.TrackingDataResource;
import br.com.intelipost.sdk.resource.ZipCodeResource;
import br.com.intelipost.sdk.response.LabelResponse;
import br.com.intelipost.sdk.response.QuoteResponse;
import br.com.intelipost.sdk.response.Response;
import br.com.intelipost.sdk.response.ShipmentOrderResponse;
import br.com.intelipost.sdk.response.TrackingCodeResponse;
import br.com.intelipost.sdk.response.TrackingDataResponse;
import br.com.intelipost.sdk.response.ZipCodeResponse;

import java.util.List;

public class IntelipostClient {

    private ZipCodeResource zipCodeResource;
    private TrackingCodeResource trackingCodeResource;
    private TrackingDataResource trackingDataResource;
    private ShipmentOrderResource shipmentOrderResource;
    private ShipmentOrderStatusResource shipmentOrderStatusResource;
    private QuoteResource quoteResource;
    private PlpResource plpResource;
    private LabelResource labelResource;

    public IntelipostClient(String apiKey) {
        zipCodeResource = new ZipCodeResource(apiKey);
        trackingCodeResource = new TrackingCodeResource(apiKey);
        trackingDataResource = new TrackingDataResource(apiKey);
        shipmentOrderResource = new ShipmentOrderResource(apiKey);
        shipmentOrderStatusResource = new ShipmentOrderStatusResource(apiKey);
        quoteResource = new QuoteResource(apiKey);
        plpResource = new PlpResource(apiKey);
        labelResource = new LabelResource(apiKey);
    }

    public ZipCodeResponse getZipCodeInfo(String zipCode) {
        return zipCodeResource.getZipCodeInfo(zipCode);
    }

    public TrackingCodeResponse getTrackingCode(TrackingCodeRequest trackingCodeRequest) {
        return trackingCodeResource.getTrackingCode(trackingCodeRequest);
    }

    public TrackingDataResponse updateTrackingData(TrackingDataRequest trackingDataRequest) {
        return trackingDataResource.updateTrackingData(trackingDataRequest);
    }

    public ShipmentOrderResponse getShipmentOrder(String orderNumber) {
        return shipmentOrderResource.getShipmentOrder(orderNumber);
    }

    public ShipmentOrderResponse doShipmentOrder(ShipmentOrderRequest requestBody) {
        return shipmentOrderResource.doShipmentOrder(requestBody);
    }

    public Response setAsCanceled(ShipmentOrderStatusRequest requestBody) {
        return shipmentOrderStatusResource.setAsCanceled(requestBody);
    }

    public Response setAsReadyToShip(List<ShipmentOrderStatusRequest> requestBody) {
        return shipmentOrderStatusResource.setAsReadyToShip(requestBody);
    }

    public Response setAsShipped(List<ShipmentOrderStatusRequest> requestBody) {
        return shipmentOrderStatusResource.setAsShipped(requestBody);
    }

    public Response sendPlp(PlpRequest requestBody){
        return plpResource.send(requestBody);
    }

    public QuoteResponse getShippingQuote(Long idQuote) {
        return quoteResource.getShippingQuote(idQuote);
    }

    public QuoteResponse doShippingQuote(QuoteRequest requestBody) {
        return quoteResource.doShippingQuote(requestBody);
    }

    public LabelResponse getLabel(String orderNumber, Integer shipmentOrderVolumeNumber){
        return labelResource.getLabel(orderNumber, shipmentOrderVolumeNumber);
    }
}
