package br.com.intelipost.sdk.dsl;

import br.com.intelipost.sdk.request.ShipmentOrderCustomerResquest;

public class ShipmentOrderCustomerDSL {

    private ShipmentOrderCustomerResquest customer;

    private ShipmentOrderCustomerDSL(){
        customer = new ShipmentOrderCustomerResquest();
    }

    public static ShipmentOrderCustomerDSL newCustomer(){
        return new ShipmentOrderCustomerDSL();
    }

    public ShipmentOrderCustomerDSL firstName(String firstName){
        customer.setFirstName(firstName);
        return this;
    }

    public ShipmentOrderCustomerDSL lastName(String lastName){
        customer.setLastName(lastName);
        return this;
    }

    public ShipmentOrderCustomerDSL email(String email){
        customer.setEmail(email);
        return this;
    }

    public ShipmentOrderCustomerDSL phone(String phone){
        customer.setPhone(phone);
        return this;
    }

    public ShipmentOrderCustomerDSL cellPhone(String cellPhone){
        customer.setCellphone(cellPhone);
        return this;
    }

    public ShipmentOrderCustomerDSL federalTaxPayerId(String federalTaxPayerId){
        customer.setTaxPayerId(federalTaxPayerId);
        return this;
    }

    public ShipmentOrderCustomerDSL withShippingInfo(){
        return this;
    }

    public ShipmentOrderCustomerDSL address(String shippingAddress){
        customer.setShippingAddress(shippingAddress);
        return this;
    }

    public ShipmentOrderCustomerDSL number(String shippingNumber){
        customer.setShippingNumber(shippingNumber);
        return this;
    }

    public ShipmentOrderCustomerDSL additionalInfo(String shippingAdditionalInfo){
        customer.setShippingAdditionalInfo(shippingAdditionalInfo);
        return this;
    }

    public ShipmentOrderCustomerDSL neighborhood(String shippingNeighborhood){
        customer.setShippingQuarter(shippingNeighborhood);
        return this;
    }

    public ShipmentOrderCustomerDSL city(String shippingCity){
        customer.setShippingCity(shippingCity);
        return this;
    }

    public ShipmentOrderCustomerDSL state(String shippingState){
        customer.setShippingState(shippingState);
        return this;
    }

    public ShipmentOrderCustomerDSL zipCode(String shippingZipCode){
        customer.setShippingZipCode(shippingZipCode);
        return this;
    }

    public ShipmentOrderCustomerDSL country(String shippingCountry){
        customer.setShippingCountry(shippingCountry);
        return this;
    }

    public ShipmentOrderCustomerResquest serialize() {
        return this.customer;
    }

}
