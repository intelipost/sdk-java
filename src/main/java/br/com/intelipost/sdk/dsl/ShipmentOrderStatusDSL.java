package br.com.intelipost.sdk.dsl;

import java.util.ArrayList;
import java.util.List;

import br.com.intelipost.sdk.request.ShipmentOrderStatusRequest;

public class ShipmentOrderStatusDSL {

    private List<ShipmentOrderStatusRequest> shipmentOrderStatus;

    private ShipmentOrderStatusDSL() {
        shipmentOrderStatus = new ArrayList<>();
    }

    public static ShipmentOrderStatusDSL newShipmentOrderStatus(){
        return new ShipmentOrderStatusDSL();
    }

    public ShipmentOrderStatusDSL withShipmentOrder(String orderNumber){

        ShipmentOrderStatusRequest shipmentOrderStatusRequest = new ShipmentOrderStatusRequest();
        shipmentOrderStatusRequest.setOrderNumber(orderNumber);

        shipmentOrderStatus.add(shipmentOrderStatusRequest);
        return this;
    }


    public List<ShipmentOrderStatusRequest> serialize() {
        return this.shipmentOrderStatus;
    }

    public ShipmentOrderStatusRequest singleSerialize() {
        return this.shipmentOrderStatus.stream().findFirst().get();
    }

}
