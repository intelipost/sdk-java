package br.com.intelipost.sdk.unit;

import static br.com.intelipost.sdk.util.JsonLoader.loadFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.intelipost.sdk.client.IntelipostClient;
import br.com.intelipost.sdk.dsl.TrackingDataDSL;
import br.com.intelipost.sdk.request.TrackingCodeRequest;
import br.com.intelipost.sdk.request.TrackingDataRequest;
import br.com.intelipost.sdk.response.ShipmentOrderResponse;
import br.com.intelipost.sdk.response.TrackingCodeResponse;

@RunWith(MockitoJUnitRunner.class)
public class TrackingTest {

    @Mock
    private IntelipostClient intelipostClient;

    @Before
    public void before() {
        TrackingCodeResponse trackingCode = loadFile(TrackingCodeResponse.class, "/TrackingCode.json");
        when(intelipostClient.getTrackingCode(anyObject())).thenReturn(trackingCode);

        ShipmentOrderResponse shipmentOrder = loadFile(ShipmentOrderResponse.class, "/ShipmentOrder.json");
        when(intelipostClient.getShipmentOrder(anyString())).thenReturn(shipmentOrder);
    }

    @Test
    public void shouldTrackingCodeReturnInfo() {
        Integer method = 1;
        String quantity = "1";

        TrackingCodeRequest trackingCodeRequest = new TrackingCodeRequest(method, quantity);
        TrackingCodeResponse trackingCodeResponse = intelipostClient.getTrackingCode(trackingCodeRequest);

        assertThat(trackingCodeResponse.getTrackingCodes().size(), equalTo(1));
    }

    @Test
    public void shouldTrackingDataUpdate() {

        String newTrackingCode = "NEW_TRACKING_CODE";

        ShipmentOrderResponse shipmentOrder = intelipostClient.getShipmentOrder("1");

        shipmentOrder.getOrderVolumes().forEach(vol -> {
            TrackingDataRequest data = TrackingDataDSL.newTrackingDataDSL()
                    .orderNumber(shipmentOrder.getOrderNumber())
                    .withVolumes()
                    .volumeTrackingCode(vol.getVolumeNumber(), newTrackingCode)
                    .serialize();

            intelipostClient.updateTrackingData(data);
        });

        ShipmentOrderResponse response = loadFile(ShipmentOrderResponse.class, "/ShipmentOrderUpdatedTracking.json");
        when(intelipostClient.getShipmentOrder(anyString())).thenReturn(response);

        boolean updated = intelipostClient.getShipmentOrder("1")
                .getOrderVolumes()
                .stream()
                .allMatch(vol -> vol.getTrackingCode().equals(newTrackingCode));

        Assert.assertTrue(updated);
    }
}
