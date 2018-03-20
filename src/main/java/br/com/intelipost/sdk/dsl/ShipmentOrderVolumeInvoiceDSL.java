package br.com.intelipost.sdk.dsl;

import java.time.ZonedDateTime;

import br.com.intelipost.sdk.request.ShipmentOrderVolumeInvoiceRequest;

public class ShipmentOrderVolumeInvoiceDSL {

    private ShipmentOrderVolumeInvoiceRequest invoice;

    private ShipmentOrderVolumeInvoiceDSL(){
        invoice = new ShipmentOrderVolumeInvoiceRequest();
    }

    public static ShipmentOrderVolumeInvoiceDSL newVolumeInvoice(){
        return new ShipmentOrderVolumeInvoiceDSL();
    }

    public ShipmentOrderVolumeInvoiceDSL series(Integer series){
        invoice.setSeries(series);
        return this;
    }

    public ShipmentOrderVolumeInvoiceDSL number(Long number){
        invoice.setNumber(number);
        return this;
    }

    public ShipmentOrderVolumeInvoiceDSL key(String key){
        invoice.setKey(key);
        return this;
    }

    public ShipmentOrderVolumeInvoiceDSL date(ZonedDateTime date){
        invoice.setDate(date);
        return this;
    }

    public ShipmentOrderVolumeInvoiceDSL total(Double amount){
        invoice.setTotalValue(amount);
        return this;
    }

    public ShipmentOrderVolumeInvoiceDSL productTotal(Double amount){
        invoice.setProductValue(amount);
        return this;
    }

    public ShipmentOrderVolumeInvoiceDSL cfop(String cfop){
        invoice.setCfop(cfop);
        return this;
    }

    public ShipmentOrderVolumeInvoiceRequest serialize() {
        return this.invoice;
    }
}
