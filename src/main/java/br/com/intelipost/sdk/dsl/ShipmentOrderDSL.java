package br.com.intelipost.sdk.dsl;

import java.time.OffsetDateTime;
import java.util.List;

import br.com.intelipost.sdk.request.ShipmentOrderCustomerResquest;
import br.com.intelipost.sdk.request.ShipmentOrderRequest;
import br.com.intelipost.sdk.request.ShipmentOrderVolumeRequest;

public class ShipmentOrderDSL {

    private ShipmentOrderRequest shipmentOrder;

    private ShipmentOrderDSL(){
        shipmentOrder = new ShipmentOrderRequest();
    }

    public static ShipmentOrderDSL newShipmentOrder(){
        return new ShipmentOrderDSL();
    }

    public ShipmentOrderDSL idQuote(Long idQuote){
        shipmentOrder.setIdQuote(idQuote);
        return this;
    }

    public ShipmentOrderDSL shippingCost(Double amount){
        shipmentOrder.setShippingCost(amount);
        return this;
    }

    public ShipmentOrderDSL orderNumber(String orderNumber){
        shipmentOrder.setOrderNumber(orderNumber);
        return this;
    }

    public ShipmentOrderDSL salesOrderNumber(Long orderNumber){
        shipmentOrder.setSalesOrderNumber(orderNumber);
        return this;
    }

    public ShipmentOrderDSL idDeliveryMethod(Integer idDeliveryMethod){
        shipmentOrder.setIdDeliveryMethod(idDeliveryMethod);
        return this;
    }

    public ShipmentOrderDSL warehouse(String warehouseCode){
        shipmentOrder.setWarehouseCode(warehouseCode);
        return this;
    }

    public ShipmentOrderDSL withCustomer(ShipmentOrderCustomerResquest customer){
        shipmentOrder.setCustomer(customer);
        return this;
    }

    public ShipmentOrderDSL withVolumes(List<ShipmentOrderVolumeRequest> volumes){
        shipmentOrder.setOrderVolumes(volumes);
        return this;
    }

    public ShipmentOrderDSL shippedDate(OffsetDateTime shippedDate){
        shipmentOrder.setShippedDate(shippedDate);
        return this;
    }

    public ShipmentOrderRequest serialize() {
        return this.shipmentOrder;
    }

}
