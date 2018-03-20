package br.com.intelipost.sdk.dsl;

import br.com.intelipost.sdk.request.QuoteProductRequest;

public class QuoteProductDSL {
    private QuoteProductRequest product;

    private QuoteProductDSL(){
        product = new QuoteProductRequest();
    }

    public static QuoteProductDSL newProduct(){
        return new QuoteProductDSL();
    }
    
    public QuoteProductDSL sku(String sku){
        product.setIdSku(sku);
        return this;
    }

    public QuoteProductDSL description(String description){
        product.setDescription(description);
        return this;
    }

    public QuoteProductDSL height(Double height){
        product.setHeight(height);
        return this;
    }

    public QuoteProductDSL length(Double length){
        product.setLength(length);
        return this;
    }

    public QuoteProductDSL weight(Double weight){
        product.setWeight(weight);
        return this;
    }

    public QuoteProductDSL width(Double width){
        product.setWidth(width);
        return this;
    }

    public QuoteProductDSL quantity(Integer quantity){
        product.setQuantity(quantity);
        return this;
    }

    public QuoteProductDSL unitPrice(Double value){
        product.setUnitPrice(value);
        return this;
    }

    public QuoteProductRequest serialize(){
        return product;
    }
}
