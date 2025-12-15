package com.codeline.SpringBoot.RequestObject;


import com.codeline.SpringBoot.Entities.PhoneNumber;
import com.codeline.SpringBoot.Entities.Student;
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
public class PhoneNumberCreateRequest {

    private Integer number;
    private String countryCode;
    private Boolean isLandLine;

    public static PhoneNumber convertToPhoneNumber(PhoneNumberCreateRequest request) {
        PhoneNumber phoneNumber = new PhoneNumber();
        if (request != null) {
            phoneNumber.setNumber(request.getNumber());
            phoneNumber.setCountryCode(request.getCountryCode());
            phoneNumber.setIsLandLine(request.getIsLandLine());
        }
        return phoneNumber;
    }

    public static void validCreatePhoneRequest(PhoneNumberCreateRequest request) throws Exception {

        if (HelperUtils.isNull(request.getNumber()) || request.getNumber() <= 0) {
            throw new Exception(Constants.PHONE_CREATE_REQUEST_NUMBER_NOT_VALID);
        }
        else if (HelperUtils.isNull(request.getCountryCode()) || request.getCountryCode().isBlank() || request.getCountryCode().isEmpty()) {
            throw new Exception(Constants.PHONE_CREATE_REQUEST_COUNTRY_CODE_NOT_VALID);
        }
       else if (HelperUtils.isNull(request.getIsLandLine())) {
            throw new Exception(Constants.PHONE_CREATE_REQUEST_IS_LANDLINE_NOT_VALID);
        }
    }
}
