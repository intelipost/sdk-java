package br.com.intelipost.sdk.resource;

import br.com.intelipost.sdk.request.QuoteRequest;
import br.com.intelipost.sdk.response.QuoteResponse;
import br.com.intelipost.sdk.response.Response;
import org.apache.http.HttpHost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuoteResource extends Resource<QuoteRequest, QuoteResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuoteResource.class);

    public QuoteResource(String apiKey) {
        super(apiKey);
    }
    public QuoteResource(String apiKey, HttpHost httpHost) {
        super(apiKey, httpHost);
    }

    public QuoteResponse doShippingQuote(QuoteRequest requestBody) {
        try {

            Response<QuoteResponse> response = doPostRequest("/quote_by_product", requestBody);
            return response.getContent();

        } catch (Exception e) {
            LOGGER.info("Fail while creating quote for zip code [{}] to [{}]", requestBody.getOriginZipCode(), requestBody.getDestinationZipCode(), e);
            throw new RuntimeException("Fail while creating quote for zip code, details: " + e.getMessage(), e);
        }
    }

    public QuoteResponse getShippingQuote(Long idQuote) {
        try {

            Response<QuoteResponse> response = doGetRequest("/quote/" + idQuote);
            return response.getContent();

        } catch (Exception e) {
            LOGGER.info("Fail while consulting quote with id [{}]", idQuote, e);
            throw new RuntimeException("Fail while consulting quote, details: " + e.getMessage(), e);
        }
    }
}
