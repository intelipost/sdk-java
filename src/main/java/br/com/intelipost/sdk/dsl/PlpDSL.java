package br.com.intelipost.sdk.dsl;

import java.util.ArrayList;
import java.util.List;

import br.com.intelipost.sdk.request.PlpRequest;

public class PlpDSL {

    private PlpRequest plp;

    private PlpDSL(){
        plp = new PlpRequest();
        plp.setShipmentOrderVolumesId(new ArrayList<>(1));
    }

    public static PlpDSL newPlp(){
        return new PlpDSL();
    }

    public PlpDSL shipmentOrderVolumesId(List<Long> shipmentOrderVolumeId){
        shipmentOrderVolumeId.stream().forEach(id -> shipmentOrderVolumeId(id));
        return this;
    }

    public PlpDSL shipmentOrderVolumeId(Long shipmentOrderVolumeId){
        plp.getShipmentOrderVolumesId().add(shipmentOrderVolumeId);
        return this;
    }

    public PlpDSL logisticProvider(Integer idLogisticProvider){
        plp.setLogisticProvider(idLogisticProvider);
        return this;
    }

    public PlpRequest serialize() {
        return this.plp;
    }
}
