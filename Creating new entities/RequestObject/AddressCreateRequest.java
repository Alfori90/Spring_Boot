package com.codeline.SpringBoot.RequestObject;

import com.codeline.SpringBoot.Entities.Address;
import com.codeline.SpringBoot.Helper.HelperUtils;
import com.codeline.SpringBoot.Helper.Constants;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressCreateRequest {

    private String houseNumber;
    private String street;
    private String city;
    private String stateOrProvince;
    private String country;
    private String  postalCode;


    public static Address convertToAddress(AddressCreateRequest request) {
        Address address = new Address();
        if (request != null) {
            address.setHouseNumber(request.getHouseNumber());
            address.setStreet(request.getStreet());
            address.setCity(request.getCity());
            address.setStateOrProvince(request.getStateOrProvince());
            address.setCountry(request.getCountry());
            address.setPostalCode(request.getPostalCode());
        }
        return address;
    }

    public static void validCreateAddressRequest(AddressCreateRequest request) throws Exception {
        if (HelperUtils.isNull(request)) {
            throw new Exception(Constants.ADDRESS_REQUEST_OBJECT_IS_NULL);
        }
        else if (HelperUtils.isNull(request.getHouseNumber()) || request.getHouseNumber().isBlank()) {
            throw new Exception(Constants.ADDRESS_REQUEST_HOUSE_NUMBER_NOT_VALID);
        }
        else if (HelperUtils.isNull(request.getStreet()) || request.getStreet().isBlank()) {
            throw new Exception(Constants.ADDRESS_REQUEST_STREET_NOT_VALID);
        }
        else if (HelperUtils.isNull(request.getCity()) || request.getCity().isBlank()) {
            throw new Exception(Constants.ADDRESS_REQUEST_CITY_NOT_VALID);
        }
        else if (HelperUtils.isNull(request.getStateOrProvince()) || request.getStateOrProvince().isBlank()) {
            throw new Exception(Constants.ADDRESS_REQUEST_STATE_PROVINCE_NOT_VALID);
        }
        else if (HelperUtils.isNull(request.getCountry()) || request.getCountry().isBlank()) {
            throw new Exception(Constants.ADDRESS_REQUEST_COUNTRY_NOT_VALID);
        }
        else if (HelperUtils.isNull(request.getPostalCode()) || request.getPostalCode().isBlank()) {
            throw new Exception(Constants.ADDRESS_REQUEST_POSTAL_CODE_NOT_VALID);
        }
    }

}
