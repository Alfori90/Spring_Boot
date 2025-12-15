package com.codeline.SpringBoot.Controller;

import com.codeline.SpringBoot.Entities.PhoneNumber;
import com.codeline.SpringBoot.Entities.Student;
import com.codeline.SpringBoot.RequestObject.PhoneNumberCreateRequest;
import com.codeline.SpringBoot.Services.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class PhoneNumberController {

    @Autowired
    PhoneNumberService phoneNumberService;

    @PostMapping("/students/{id}/phoneNumbers/add")
    public PhoneNumber createPhoneNumber(@PathVariable Integer id,@RequestBody PhoneNumberCreateRequest requestObj) throws Exception{
        PhoneNumberCreateRequest.validCreatePhoneRequest(requestObj);

        PhoneNumber phoneNumber = phoneNumberService.addPhoneNumberToStudent(id, requestObj);
        return phoneNumber;
    }

    @PutMapping("/{id}/update")
    public PhoneNumber updatePhoneNumber(@RequestBody PhoneNumber updateObjFromUser) throws Exception{
        return phoneNumberService.updatePhoneNumber(updateObjFromUser);
    }

    @DeleteMapping("/{id}/delete")
    public String deletePhoneNumber(@PathVariable int id) throws Exception{
        phoneNumberService.deletePhoneNumber(id);
        return "Success";
    }


}
