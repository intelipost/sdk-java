package br.com.intelipost.sdk.dsl;

import java.util.ArrayList;
import java.util.List;

import br.com.intelipost.sdk.request.TrackingDataRequest;
import br.com.intelipost.sdk.request.TrackingDataVolumeRequest;

public class TrackingDataDSL {

    private TrackingDataRequest trackingData;

    private TrackingDataDSL(){
        trackingData = new TrackingDataRequest();
    }

    public static TrackingDataDSL newTrackingDataDSL(){
        return new TrackingDataDSL();
    }

    public TrackingDataDSL orderNumber(String orderNumber){
        trackingData.setOrderNumber(orderNumber);
        return this;
    }

    public TrackingDataDSL withVolumes(){
        trackingData.setVolumes(new ArrayList<>(1));
        return this;
    }

    public TrackingDataDSL volumesTrackingCode(List<Integer> volumes, String trackingCode){
        volumes.stream()
                .forEach(volumeNumber -> volumeTrackingCode(volumeNumber, trackingCode));
        return this;
    }

    public TrackingDataDSL volumeTrackingCode(Integer volume, String trackingCode){
        TrackingDataVolumeRequest dataVolume = new TrackingDataVolumeRequest(volume, trackingCode);
        trackingData.getVolumes().add(dataVolume);
        return this;
    }

    public TrackingDataRequest serialize(){
        return this.trackingData;
    }

}
