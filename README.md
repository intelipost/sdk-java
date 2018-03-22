[![Build Status](https://secure.travis-ci.org/intelipost/sdk-java.png?branch=master)](https://travis-ci.org/intelipost/sdk-java)
# SDK JAVA - Intelipost API V1

## Overview

SDK para auxiliar no consumo de alguns endpoints existentes na [API V1](http://api.intelipost.com.br/v1), conforme [documentação](https://docs.intelipost.com.br/v1/introducao/guia-rapido).

## Usage

Para utilizar o SDK é necessário:
  
  1. Incluir o [jar](https://search.maven.org/#search%7Cga%7C1%7Cintelipost) no classpath ou incluir a dependencia no arquivo pom.xml do Maven.
  ```xml
  <dependency>
     <groupId>br.com.intelipost</groupId>
     <artifactId>sdk-java</artifactId>
     <version>RELEASE</version>
  </dependency>
```
  
  2. Instanciar a classe IntelipostClient com sua API_KEY.
  
  ```java
    IntelipostClient intelipostClient = new IntelipostClient("SUA_API_KEY");
  ```
  
### Endpoints Disponíveis

  * CEP ( GET - /cep_location/address_complete/{cep} ), exemplo:
  
  ```java
    IntelipostClient intelipostClient = new IntelipostClient("SUA_API_KEY");
    ZipCodeResponse zipCodeInfo = intelipostClient.getZipCodeInfo("00000000");
  ```  
  
  * Cotação ( POST - /quote_by_product ), exemplo:
  
  ```java
    IntelipostClient intelipostClient = new IntelipostClient("SUA_API_KEY");
    
    QuoteProductRequest productRequest;
    productRequest= QuoteProductDSL.newProduct()
                                    .sku("MCK")
                                    .description("Mockito")
                                    .weight(66.0D)
                                    .height(10.0D)
                                    .length(3.0D)
                                    .width(11.0D)
                                    .quantity(1)
                                    .unitPrice(100.0D)
                                  .serialize();

    QuoteRequest quote;
    quote = QuoteDSL.newQuote()
                      .originZipCode("4401160")
                      .destinationZipCode("7011010")
                    .withProducts()
                      .addItem(productRequest)
                    .serialize();

    QuoteResponse quoteResponse = intelipostClient.doShippingQuote(quote);
    
  ```  
  
* Consulta Cotação ( GET - /quote/{id} ), exemplo:
  
  ```java
    Long idQuote = 122L;
    IntelipostClient intelipostClient = new IntelipostClient("SUA_API_KEY");
    QuoteResponse quote = intelipostClient.getShippingQuote(idQuote);
  ```  
  
* Pedido de Envio ( POST - /shipment_order ), exemplo:
  
  ```java
    IntelipostClient intelipostClient = new IntelipostClient("SUA_API_KEY");
    
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
              .trackingCode("TRACKING123") //OPCIONAL
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
  ```  

* Consultar Pedido de Envio ( GET - /shipment_order/{pedido_de_envio} ), exemplo:
  
  ```java
    IntelipostClient intelipostClient = new IntelipostClient("SUA_API_KEY");
    ShipmentOrderResponse shipmentOrder = intelipostClient.getShipmentOrder("1234-123");
  ```  
  
* Gerar Tracking Code ( GET - /tracking_code/{delivery_method_id}/{quantity} ), exemplo:
  
  ```java
    IntelipostClient intelipostClient = new IntelipostClient("SUA_API_KEY");
    TrackingCodeRequest trackingCodeRequest = new TrackingCodeRequest(1, "5");
    TrackingCodeResponse trackingCodeResponse = intelipostClient.getTrackingCode(trackingCodeRequest);
  ```  

* Atualizar dados de rastreamento ( POST - /shipment_order/set_tracking_data ), exemplo:
  
  ```java
    String newTrackingCode = "NEW_TRACKING_CODE";
    IntelipostClient intelipostClient = new IntelipostClient("SUA_API_KEY");

    ShipmentOrderResponse shipmentOrder = intelipostClient.getShipmentOrder("1234");

    shipmentOrder.getOrderVolumes().forEach(vol -> {
        TrackingDataRequest data = TrackingDataDSL.newTrackingDataDSL()
                    .orderNumber(shipmentOrder.getOrderNumber())
                  .withVolumes()
                    .volumeTrackingCode(vol.getVolumeNumber(), newTrackingCode)
                .serialize();

        intelipostClient.updateTrackingData(data);
    });
  ```  

* Impressão das Etiquetas ( GET - /shipment_order/get_label/{pedido_envio}/{numero_volume} ), exemplo:
  
  ```java
    IntelipostClient intelipostClient = new IntelipostClient("SUA_API_KEY");
    
    ShipmentOrderResponse shipmentOrder = intelipostClient.getShipmentOrder("3123");
    Integer volumeNumber = shipmentOrder.getOrderVolumes().stream().findFirst().get().getVolumeNumber();
    
    LabelResponse label = intelipostClient.getLabel(shipmentOrder.getOrderNumber(), volumeNumber);
  ```  

* Disparar Pré Lista de Postagem por Volume ( POST - /pre_shipment_list/send_volumes ), exemplo:
  
  ```java
    IntelipostClient intelipostClient = new IntelipostClient("SUA_API_KEY");
    
    ShipmentOrderResponse shipmentOrder = intelipostClient.getShipmentOrder("3123");
    
    List<Long> shipmentOrderVolumesId = shipmentOrder.getOrderVolumes()
            .stream()
            .map(ShipmentOrderVolumeResponse::getVolumeId)
            .collect(toList());

    PlpRequest plp = PlpDSL.newPlp()
            .logisticProvider(1)
            .shipmentOrderVolumesId(shipmentOrderVolumesId)
            .serialize();

    intelipostClient.sendPlp(plp);
  ```  

## Stack

* [Java 8](https://www.java.com/pt_BR/download/)
* [Lombok](https://projectlombok.org/)
* [Jackson](https://github.com/FasterXML/jackson-databind)




