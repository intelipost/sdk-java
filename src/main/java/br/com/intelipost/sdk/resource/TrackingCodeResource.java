package br.com.intelipost.sdk.resource;

import br.com.intelipost.sdk.request.TrackingCodeRequest;
import br.com.intelipost.sdk.response.Response;
import br.com.intelipost.sdk.response.TrackingCodeResponse;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpPost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrackingCodeResource extends Resource<TrackingCodeRequest, TrackingCodeResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrackingCodeResource.class);

    public TrackingCodeResource(String apiKey) {
        super(apiKey);
    }

    public TrackingCodeResource(String apiKey, HttpHost httpHost) {
        super(apiKey, httpHost);
    }

    public TrackingCodeResponse getTrackingCode(TrackingCodeRequest trackingCodeRequest) {
        try {

            Integer deliveryMethod = trackingCodeRequest.getIdDeliveryMethod();
            String quantity = trackingCodeRequest.getQuantity();

            Response<TrackingCodeResponse> response = doGetRequest("/tracking_code/" + deliveryMethod + "/" + quantity);
            return response.getContent();

        } catch (Exception e) {
            LOGGER.info("Fail while retrieving tracking code with parameters [{}]", trackingCodeRequest, e);
            throw new RuntimeException("Fail while retrieving tracking code, details: " + e.getMessage(), e);
        }
    }
}
