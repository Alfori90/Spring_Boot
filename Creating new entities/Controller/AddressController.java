package com.codeline.SpringBoot.Controller;

import com.codeline.SpringBoot.Entities.Address;
import com.codeline.SpringBoot.Services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class AddressController {

    @Autowired
    AddressService addressService;


    @PutMapping("/students/{id}/address/update")
    public Address updateAddress(@PathVariable Integer id, @RequestBody Address updateObjFromUser) throws Exception{
        return addressService.updateAddress(id ,updateObjFromUser);
    }
}
