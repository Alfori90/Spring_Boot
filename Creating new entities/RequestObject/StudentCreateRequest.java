package com.codeline.SpringBoot.RequestObject;

import com.codeline.SpringBoot.Entities.Address;
import com.codeline.SpringBoot.Entities.PhoneNumber;
import com.codeline.SpringBoot.Entities.Student;
import com.codeline.SpringBoot.Helper.Constants;
import com.codeline.SpringBoot.Helper.HelperUtils;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentCreateRequest {

    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;
    private String gender;

    private List<PhoneNumberCreateRequest> phoneNumbers;
    private AddressCreateRequest address;


    public static Student convertToStudent(StudentCreateRequest request) {
        Student student = new Student();
        if (request != null) {
            student.setFirstName(request.getFirstName());
            student.setLastName(request.getLastName());
            student.setEmail(request.getEmail());
            student.setDateOfBirth(request.getDateOfBirth());
            student.setGender(request.getGender());
        }
        return student;
    }

    public static void validCreateStudentRequest(StudentCreateRequest request) throws Exception {
        if (HelperUtils.isNull(request.getFirstName()) || request.getFirstName().isBlank() || request.getFirstName().isEmpty()) {
            throw new Exception(Constants.STUDENT_CREATE_REQUEST_FIRST_NAME_NOT_VALID);
        } else if (HelperUtils.isNull(request.getLastName()) || request.getLastName().isBlank() || request.getLastName().isEmpty()) {
            throw new Exception(Constants.STUDENT_CREATE_REQUEST_LAST_NAME_NOT_VALID);
        } else if (HelperUtils.isNull(request.getEmail()) || !request.getEmail().contains("@")) {
            throw new Exception(Constants.STUDENT_CREATE_REQUEST_EMAIL_NOT_VALID);
        } else if (HelperUtils.isNull(request.getDateOfBirth())) {
            throw new Exception(Constants.STUDENT_CREATE_REQUEST_DOB_NOT_VALID);
        } else if (HelperUtils.isNull(request.getGender()) ||
                request.getGender().isBlank()) {
            throw new Exception(Constants.STUDENT_CREATE_REQUEST_GENDER_NOT_VALID);
        } else if (HelperUtils.isNull(request.getPhoneNumbers()) ||
                HelperUtils.isListEmpty(request.getPhoneNumbers())) {
            throw new Exception(Constants.STUDENT_CREATE_REQUEST_PHONE_NUMBERS_NOT_VALID);
        } else if (HelperUtils.isNull(request.getAddress())) {
            throw new Exception(Constants.STUDENT_CREATE_REQUEST_ADDRESS_NOT_VALID);
        }

    }
}
