package br.com.intelipost.sdk.dsl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import br.com.intelipost.sdk.request.QuoteProductRequest;
import br.com.intelipost.sdk.request.QuoteRequest;

public class QuoteDSL {

    private QuoteRequest quote;

    private QuoteDSL(){
        quote = new QuoteRequest();
        quote.setAdditionalInformation(new HashMap<>(1));
    }

    public static QuoteDSL newQuote(){
        return new QuoteDSL();
    }

    public QuoteDSL originZipCode(String zipCode){
        quote.setOriginZipCode(zipCode);
        return this;
    }

    public QuoteDSL destinationZipCode(String zipCode){
        quote.setDestinationZipCode(zipCode);
        return this;
    }

    public QuoteDSL channel(String channel){
        if(StringUtils.isNoneBlank(channel)){
            quote.getAdditionalInformation().put("sales_channel", channel);
        }
        return this;
    }

    public QuoteDSL withProducts(){
        quote.setProducts(new ArrayList<>());
        return this;
    }

    public QuoteDSL addItem(QuoteProductRequest product){
        quote.getProducts().add(product);
        return this;
    }

    public QuoteDSL addAllItem(List<QuoteProductRequest> products){
        quote.getProducts().addAll(products);
        return this;
    }

    public QuoteRequest serialize() {
        return this.quote;
    }
}
