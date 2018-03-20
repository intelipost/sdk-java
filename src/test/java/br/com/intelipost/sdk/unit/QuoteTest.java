package br.com.intelipost.sdk.unit;

import static br.com.intelipost.sdk.util.JsonLoader.loadFile;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.intelipost.sdk.client.IntelipostClient;
import br.com.intelipost.sdk.dsl.QuoteDSL;
import br.com.intelipost.sdk.dsl.QuoteProductDSL;
import br.com.intelipost.sdk.request.QuoteProductRequest;
import br.com.intelipost.sdk.request.QuoteRequest;
import br.com.intelipost.sdk.response.QuoteResponse;

@RunWith(MockitoJUnitRunner.class)
public class QuoteTest {

    @Mock
    private IntelipostClient intelipostClient;

    @Before
    public void before() {
        QuoteResponse quoteResponse = loadFile(QuoteResponse.class, "/Quote.json");
        when(intelipostClient.doShippingQuote(anyObject())).thenReturn(quoteResponse);
        when(intelipostClient.getShippingQuote(anyLong())).thenReturn(quoteResponse);
    }

    @Test
    public void shouldQuoteReturnInfo() {

        QuoteProductRequest productRequest = QuoteProductDSL.newProduct()
                .sku("MCK")
                .description("Mockito")
                .weight(66.0D)
                .height(10.0D)
                .length(3.0D)
                .width(11.0D)
                .quantity(1)
                .unitPrice(100.0D)
                .serialize();

        QuoteRequest quote = QuoteDSL.newQuote()
                .originZipCode("4401160")
                .destinationZipCode("7011010")
                .withProducts()
                .addItem(productRequest)
                .serialize();

        QuoteResponse quoteResponse = intelipostClient.doShippingQuote(quote);
        Assert.assertNotNull(quoteResponse);
    }

    @Test
    public void shouldQuoteReturnShippingMethods() {

        QuoteProductRequest productRequest = QuoteProductDSL.newProduct()
                .sku("MCK")
                .description("Mockito")
                .weight(66.0D)
                .height(10.0D)
                .length(3.0D)
                .width(11.0D)
                .quantity(1)
                .unitPrice(100.0D)
                .serialize();

        QuoteRequest quote = QuoteDSL.newQuote()
                .originZipCode("4401160")
                .destinationZipCode("7011010")
                .withProducts()
                .addItem(productRequest)
                .serialize();

        QuoteResponse quoteResponse = intelipostClient.doShippingQuote(quote);
        Assert.assertThat(quoteResponse.getQuoteShippingMethods().size(), Matchers.greaterThan(1));
    }

    @Test
    public void shouldQuoteExists() {

        Long idQuote = 122L;
        QuoteResponse quote = intelipostClient.getShippingQuote(idQuote);

        Assert.assertThat(quote.getVolumes().size(), Matchers.greaterThan(0));
    }

}
