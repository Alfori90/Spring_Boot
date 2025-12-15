package com.codeline.SpringBoot.ResponseObject;


import com.codeline.SpringBoot.Entities.Address;
import com.codeline.SpringBoot.Entities.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressCreateResponse {
    private int id;
    private String houseNumber;
    private String street;
    private String city;
    private String stateOrProvince;
    private String country;
    private String  postalCode;

    public static AddressCreateResponse convertToAddressResponse(Address entity) {
        AddressCreateResponse response = AddressCreateResponse.builder()
                .id(entity.getId())
                .houseNumber(entity.getHouseNumber())
                .street(entity.getStreet())
                .city(entity.getCity())
                .stateOrProvince(entity.getStateOrProvince())
                .country(entity.getCountry())
                .postalCode(entity.getPostalCode())
                .build();

        return response;
    }
}
