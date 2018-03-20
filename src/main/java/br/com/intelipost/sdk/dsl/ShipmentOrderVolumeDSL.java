package br.com.intelipost.sdk.dsl;

import br.com.intelipost.sdk.request.ShipmentOrderVolumeInvoiceRequest;
import br.com.intelipost.sdk.request.ShipmentOrderVolumeRequest;

public class ShipmentOrderVolumeDSL {

    private ShipmentOrderVolumeRequest orderVolume;

    private ShipmentOrderVolumeDSL(){
        orderVolume = new ShipmentOrderVolumeRequest();
    }

    public static ShipmentOrderVolumeDSL newOrderVolume(){
        return new ShipmentOrderVolumeDSL();
    }


    public ShipmentOrderVolumeDSL volumeNumber(Integer number){
        orderVolume.setVolumeNumber(number);
        return this;
    }

    public ShipmentOrderVolumeDSL weight(Double weight){
        orderVolume.setWeight(weight);
        return this;
    }

    public ShipmentOrderVolumeDSL width(Double width){
        orderVolume.setWidth(width);
        return this;
    }

    public ShipmentOrderVolumeDSL height(Double height){
        orderVolume.setHeight(height);
        return this;
    }

    public ShipmentOrderVolumeDSL length(Double length){
        orderVolume.setLength(length);
        return this;
    }

    public ShipmentOrderVolumeDSL quantity(Integer quantity){
        orderVolume.setQuantity(quantity);
        return this;
    }

    public ShipmentOrderVolumeDSL trackingCode(String trackingCode){
        orderVolume.setTrackingCode(trackingCode);
        return this;
    }

    public ShipmentOrderVolumeDSL withInvoice(ShipmentOrderVolumeInvoiceRequest invoice){
        orderVolume.setInvoice(invoice);
        return this;
    }

    public ShipmentOrderVolumeRequest serialize() {
        return this.orderVolume;
    }

}
