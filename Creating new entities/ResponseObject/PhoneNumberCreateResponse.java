package com.codeline.SpringBoot.ResponseObject;

import com.codeline.SpringBoot.Entities.PhoneNumber;
import com.codeline.SpringBoot.Entities.Student;
import com.codeline.SpringBoot.RequestObject.PhoneNumberCreateRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneNumberCreateResponse {

    private int id;
    private Integer number;
    private String countryCode;
    private Boolean isLandLine;

  // convert entity to response
    public static PhoneNumberCreateResponse convertToPhoneResponse(PhoneNumber entity) {
        PhoneNumberCreateResponse response = PhoneNumberCreateResponse.builder()
                .id(entity.getId())
                .number(entity.getNumber())
                .countryCode(entity.getCountryCode())
                .isLandLine(entity.getIsLandLine())
                .build();
        return response;
    }
}
