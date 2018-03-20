package br.com.intelipost.sdk.unit;

import static br.com.intelipost.sdk.util.JsonLoader.loadFile;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.intelipost.sdk.client.IntelipostClient;
import br.com.intelipost.sdk.dsl.ShipmentOrderCustomerDSL;
import br.com.intelipost.sdk.dsl.ShipmentOrderDSL;
import br.com.intelipost.sdk.dsl.ShipmentOrderStatusDSL;
import br.com.intelipost.sdk.dsl.ShipmentOrderVolumeDSL;
import br.com.intelipost.sdk.dsl.ShipmentOrderVolumeInvoiceDSL;
import br.com.intelipost.sdk.request.ShipmentOrderCustomerResquest;
import br.com.intelipost.sdk.request.ShipmentOrderRequest;
import br.com.intelipost.sdk.request.ShipmentOrderStatusRequest;
import br.com.intelipost.sdk.request.ShipmentOrderVolumeInvoiceRequest;
import br.com.intelipost.sdk.request.ShipmentOrderVolumeRequest;
import br.com.intelipost.sdk.response.Response;
import br.com.intelipost.sdk.response.ShipmentOrderResponse;

@RunWith(MockitoJUnitRunner.class)
public class ShipmentOrderTest {

    @Mock
    private IntelipostClient intelipostClient;

    @Before
    public void before() {
        ShipmentOrderResponse shipmentOrder = loadFile(ShipmentOrderResponse.class, "/ShipmentOrder.json");
        when(intelipostClient.doShipmentOrder(anyObject())).thenReturn(shipmentOrder);
        when(intelipostClient.getShipmentOrder(anyString())).thenReturn(shipmentOrder);

        Response response = loadFile(Response.class, "/ShipmentOrderUpdated.json");
        when(intelipostClient.setAsCanceled(anyObject())).thenReturn(response);
        when(intelipostClient.setAsShipped(anyObject())).thenReturn(response);

        ShipmentOrderResponse shipmentOrder2 = loadFile(ShipmentOrderResponse.class, "/ShipmentOrderShipped.json");
        when(intelipostClient.getShipmentOrder("12")).thenReturn(shipmentOrder2);
    }

    @Test
    public void shouldShipmentOrderBeCreatead() {

        ShipmentOrderVolumeInvoiceRequest orderVolumeInvoice;
        ShipmentOrderVolumeRequest orderVolume;
        ShipmentOrderCustomerResquest orderCustomer;
        ShipmentOrderRequest shipmentOrder;
        List<ShipmentOrderVolumeRequest> orderVolumes = new ArrayList<>(1);

        orderVolumeInvoice = ShipmentOrderVolumeInvoiceDSL.newVolumeInvoice()
                .cfop("61258")
                .key("13245613963285523155248613218512318651321135")
                .series(1)
                .number(3335131L)
                .date(ZonedDateTime.parse("2017-05-03T11:26:06.674Z"))
                .productTotal(110D)
                .total(160D)
                .serialize();

        orderVolume = ShipmentOrderVolumeDSL.newOrderVolume()
                .height(16D)
                .length(10D)
                .width(10D)
                .weight(170D)
                .quantity(1)
                .trackingCode("TRACKING123")
                .volumeNumber(1)
                .withInvoice(orderVolumeInvoice)
                .serialize();

        orderVolumes.add(orderVolume);


        orderCustomer = ShipmentOrderCustomerDSL.newCustomer()
                .email("teste@teste.com")
                .firstName("teste")
                .lastName("teste")
                .phone("11 55555555555")
                .federalTaxPayerId("19100000000")
                .withShippingInfo()
                .address("Rua teste")
                .additionalInfo("add")
                .neighborhood("mock")
                .number("152")
                .country("BR")
                .state("Amazonas")
                .city("Manaus")
                .zipCode("05433020")
                .serialize();

        shipmentOrder = ShipmentOrderDSL.newShipmentOrder()
                .idQuote(123L)
                .idDeliveryMethod(2)
                .orderNumber("123")
                .shippingCost(50D)
                .shippedDate(OffsetDateTime.now())
                .withCustomer(orderCustomer)
                .withVolumes(orderVolumes)
                .serialize();

        ShipmentOrderResponse shipmentOrderResponse = intelipostClient.doShipmentOrder(shipmentOrder);

        assertThat(shipmentOrderResponse.getIdShipmentOrder(), Matchers.notNullValue());
    }

    @Test
    public void shouldShipmentOrderReturnInfo() {
        ShipmentOrderResponse shipmentOrder = intelipostClient.getShipmentOrder("1");
        assertThat(shipmentOrder.getCreated(), Matchers.notNullValue());
    }

    @Test
    public void shouldShipmentOrderBeCanceled() {
        ShipmentOrderStatusRequest shipmentOrderStatusRequest = ShipmentOrderStatusDSL.newShipmentOrderStatus()
                .withShipmentOrder("1")
                .singleSerialize();

        Response response = intelipostClient.setAsCanceled(shipmentOrderStatusRequest);

        Assert.assertEquals("OK", response.getStatus());
    }

    @Test
    public void shouldShipmentOrderStatusUpdateToShipped() {
        List<ShipmentOrderStatusRequest> statusRequests = ShipmentOrderStatusDSL.newShipmentOrderStatus()
                .withShipmentOrder("1")
                .serialize();

        intelipostClient.setAsShipped(statusRequests);

        ShipmentOrderResponse order = intelipostClient.getShipmentOrder("12");

        assertThat(order.getShippedDate(), Matchers.notNullValue());
    }
}
