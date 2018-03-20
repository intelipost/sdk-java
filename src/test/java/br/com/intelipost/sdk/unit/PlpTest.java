package br.com.intelipost.sdk.unit;

import static br.com.intelipost.sdk.util.JsonLoader.loadFile;
import static java.util.stream.Collectors.toList;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.intelipost.sdk.client.IntelipostClient;
import br.com.intelipost.sdk.dsl.PlpDSL;
import br.com.intelipost.sdk.request.PlpRequest;
import br.com.intelipost.sdk.response.Response;
import br.com.intelipost.sdk.response.ShipmentOrderResponse;
import br.com.intelipost.sdk.response.ShipmentOrderVolumeResponse;

@RunWith(MockitoJUnitRunner.class)
public class PlpTest {

    @Mock
    private IntelipostClient intelipostClient;

    @Before
    public void before() {
        Response response = loadFile(Response.class, "/Plp.json");
        when(intelipostClient.sendPlp(anyObject())).thenReturn(response);
    }

    @Test
    public void shouldPlpSend() {

        ShipmentOrderResponse shipmentOrder = loadFile(ShipmentOrderResponse.class, "/ShipmentOrder.json");

        List<Long> shipmentOrderVolumesId = shipmentOrder.getOrderVolumes()
                .stream()
                .map(ShipmentOrderVolumeResponse::getVolumeId)
                .collect(toList());

        PlpRequest plp = PlpDSL.newPlp()
                .logisticProvider(1)
                .shipmentOrderVolumesId(shipmentOrderVolumesId)
                .serialize();

        Response<Object> response = intelipostClient.sendPlp(plp);
        String key = response.getMessages().stream().findFirst().get().getKey();

        Assert.assertEquals("pre.shipment.list.scheduled", key);
    }
}
