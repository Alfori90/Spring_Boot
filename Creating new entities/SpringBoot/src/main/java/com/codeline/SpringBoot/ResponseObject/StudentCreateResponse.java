package com.codeline.SpringBoot.ResponseObject;
import com.codeline.SpringBoot.Entities.Student;
import com.codeline.SpringBoot.ResponseObject.PhoneNumberCreateResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentCreateResponse {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;
    private String gender;

    private List<PhoneNumberCreateResponse> phoneNumbers;

    private AddressCreateResponse address ;


    public static StudentCreateResponse convertToStudentResponse(Student entity) {
        StudentCreateResponse response = StudentCreateResponse.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .dateOfBirth(entity.getDateOfBirth())
                .gender(entity.getGender())
                .phoneNumbers(
                        entity.getPhoneNumbers() == null ? null :
                                entity.getPhoneNumbers()
                                        .stream()
                                        .map(PhoneNumberCreateResponse::convertToPhoneResponse)
                                        .collect(Collectors.toList())
                )
                .address(entity.getAddress()== null ? null :
                        AddressCreateResponse.convertToAddressResponse(entity.getAddress()))
                .build();
        return response;
    }
}
