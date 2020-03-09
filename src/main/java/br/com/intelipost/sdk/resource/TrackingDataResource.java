package br.com.intelipost.sdk.resource;

import br.com.intelipost.sdk.request.TrackingDataRequest;
import br.com.intelipost.sdk.response.Response;
import br.com.intelipost.sdk.response.TrackingDataResponse;
import org.apache.http.HttpHost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrackingDataResource extends Resource<TrackingDataRequest, TrackingDataResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrackingDataResource.class);

    public TrackingDataResource(String apiKey) {
        super(apiKey);
    }

    public TrackingDataResource(String apiKey, HttpHost httpHost) {
        super(apiKey, httpHost);
    }


    public TrackingDataResponse updateTrackingData(TrackingDataRequest trackingDataRequest) {
        try {
            Response<TrackingDataResponse> response = doPostRequest("/shipment_order/set_tracking_data", trackingDataRequest);
            return response.getContent();
        } catch (Exception e) {
            LOGGER.info("Fail while updating tracking data with parameters [{}]", trackingDataRequest, e);
            throw new RuntimeException("Fail while updating tracking data, details: " + e.getMessage(), e);
        }
    }
}
